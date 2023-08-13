package com.example.practiceapp02.service;

import com.example.practiceapp02.model.Memo;
import com.example.practiceapp02.model.MemoForm;
import com.example.practiceapp02.repository.MemoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * メモのDB処理に使うデータをrepositoryに渡すクラス
 */
@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoMapper memoMapper;

    /**
     * メモ一覧を取得
     * @return メモ一覧
     */
    public List<Memo> getMemoList() {
        return memoMapper.getMemoList();
    }

    /**
     * メモの新規作成
     * @param memoForm メモフォーム
     */
    @Transactional
    public void createMemo(MemoForm memoForm) {
        memoMapper.save(memoForm);
    }

    /**
     * IDに紐づくメモを取得
     * @param id メモID
     * @return メモ
     */
    public List<Memo> findById(long id) {
        return memoMapper.findById(id);
    }

    /**
     * メモの更新
     * @param memoForm メモフォーム
     */
    @Transactional
    public void updateMemo(MemoForm memoForm) {
        memoMapper.updateMemo(memoForm);
    }

    /**
     * IDに紐づくメモの論理削除
     * @param id メモID
     */
    @Transactional
    public void deleteMemo(long id) {
        memoMapper.deleteMemo(id);
    }

    /**
     * 論理削除済みのメモを取得
     * @return メモ一覧
     */
    public List<Memo> getDeletedMemoList() {
        return memoMapper.getDeletedMemoList();
    }

    /**
     * 論理削除のキャンセル
     * @param id メモID
     */
    @Transactional
    public void cancelDeleteById(long id) {
        memoMapper.cancelDeleteById(id);
    }

    /**
     * IDに紐づく論理削除済みのメモを物理削除
     * @param id メモID
     */
    @Transactional
    public void removeById(long id) {
        memoMapper.removeById(id);
    }

    /**
     * 論理削除済みのメモを全て物理削除
     */
    @Transactional
    public void removeAllMemo() {
        memoMapper.removeAllMemo();
    }
}
