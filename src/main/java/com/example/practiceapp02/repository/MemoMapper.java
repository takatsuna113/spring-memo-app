package com.example.practiceapp02.repository;

import com.example.practiceapp02.model.Memo;
import com.example.practiceapp02.model.MemoForm;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DB接続をするクラス
 */
@Mapper
@Repository
public interface MemoMapper {
    /**
     * メモ一覧を取得
     * @return メモ一覧
     */
    List<Memo> getMemoList();

    /**
     * メモの保存処理
     * @param memoForm メモフォーム
     */
    void save(MemoForm memoForm);

    /**
     * IDに紐づくメモを取得
     * @param id メモID
     * @return メモ
     */
    List<Memo> findById(long id);

    /**
     * メモの更新処理
     * @param memoForm メモフォーム
     */
    void updateMemo(MemoForm memoForm);

    /**
     * メモの論理削除
     * @param id メモID
     */
    void deleteMemo(long id);

    /**
     * 論理削除済みのメモを取得
     * @return メモ一覧
     */
    List<Memo> getDeletedMemoList();

    /**
     * 論理削除のキャンセル
     * @param id メモID
     */
    void cancelDeleteById(long id);

    /**
     * IDに紐づくメモの物理削除
     * @param id メモID
     */
    void removeById(long id);

    /**
     * メモを全て物理削除
     */
    void removeAllMemo();
}
