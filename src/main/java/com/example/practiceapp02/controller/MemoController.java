package com.example.practiceapp02.controller;

import com.example.practiceapp02.model.Memo;
import com.example.practiceapp02.model.MemoForm;
import com.example.practiceapp02.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * メモのデータを利用して画面表示をするクラス
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/memo")
public class MemoController {

    private final MemoService memoService;

    @ModelAttribute("memoList")
    public List<Memo> getMemoList() {
        List<Memo> memoList = memoService.getMemoList();
        return memoList;
    }

    /**
     * メモ一覧ページを表示
     * @param model モデル
     * @return メモ一覧ページ
     */
    @GetMapping
    public String showMemoList(@ModelAttribute(name = "memoList") List<Memo> memoList) {
//        model.addAttribute("memoList", memoService.getMemoList());
        return "memo-list";
    }

    /**
     * メモの新規作成処理
     * @param memoForm メモフォーム
     * @return メモ一覧ページ
     */
    @PostMapping
    public String createMemo(MemoForm memoForm) {
        memoService.createMemo(memoForm);
        return "redirect:/memo";
    }

    /**
     * メモの新規作成ページを表示
     * @param memoForm メモフォーム
     * @return メモの新規作成ページ
     */
    @GetMapping("/create")
    public String showCreatePage(@ModelAttribute MemoForm memoForm) {
        return "creation-form";
    }

    /**
     * メモ詳細ページを表示
     * @param id メモID
     * @param model モデル
     * @return メモ詳細ページ
     */
    @GetMapping("/detail/{id}")
    public String showDetailPage(@ModelAttribute(name = "memoList") List<Memo> memoList, @PathVariable("id") long id, Model model) {
        model.addAttribute("memoDetail", memoService.findById(id));
        return  "memo-list";
    }

    /**
     * メモ編集ページを表示
     * @param id メモID
     * @param model モデル
     * @param memoForm メモフォーム
     * @return メモ編集ページ
     */
    @GetMapping("/edit/{id}")
    public String showEditPage(@PathVariable("id") long id, Model model, @ModelAttribute MemoForm memoForm) {
        model.addAttribute("memoDetail", memoService.findById(id));
        return "memo-edit";
    }

    /**
     * メモの更新処理
     * @param memoForm メモフォーム
     * @return メモ詳細ページ
     */
    @PostMapping("/edit/{id}")
    public String updateMemo(MemoForm memoForm) {
        memoService.updateMemo(memoForm);
        return "redirect:/memo/detail/{id}";
    }

    /**
     * メモの論理削除(id選択)
     * @param id メモID
     * @return メモ一覧ページ
     */
    @GetMapping("/delete/{id}")
    public String deleteMemo(@PathVariable("id") long id) {
        memoService.deleteMemo(id);
        return "redirect:/memo";
    }

    /**
     * ゴミ箱ページを表示
     * @param model モデル
     * @return ゴミ箱ページ
     */
    @GetMapping("/garbage")
    public String showDeletedPage(Model model) {
        model.addAttribute("deletedMemoList", memoService.getDeletedMemoList());
        return "memo-deleted";
    }

    /**
     * 論理削除のキャンセル
     * @param id メモID
     * @return ゴミ箱ページ
     */
    @GetMapping("/cancelDelete/{id}")
    public String cancelDelete(@PathVariable("id") long id) {
        memoService.cancelDeleteById(id);
        return "redirect:/memo/garbage";
    }

    /**
     * 論理削除済みのメモを物理削除
     * @param id メモID
     * @return ゴミ箱ページ
     */
    @GetMapping("/remove/{id}")
    public String removeById(@PathVariable("id") long id) {
        memoService.removeById(id);
        return "redirect:/memo/garbage";
    }

    /**
     * 論理削除済みのメモを全て物理削除
     * @return ゴミ箱ページ
     */
    @GetMapping("/removeAll")
    public String removeAllMemo() {
        memoService.removeAllMemo();
        return "redirect:/memo/garbage";
    }
}
