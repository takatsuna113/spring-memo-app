package com.example.practiceapp02.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * メモのデータを管理するクラス
 */
@Data
public class Memo {
    // メモID
    private long id;
    // タイトル
    private String title;
    // コンテンツ
    private String content;
    // 削除フラグ
    private boolean deleted;
    // 作成日
    private String createdAt;
    // 更新日
    private String updatedAt;
}
