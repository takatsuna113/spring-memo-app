package com.example.practiceapp02.model;

import lombok.Data;

/**
 * フォームの値を管理するクラス
 */
@Data
public class MemoForm {
    // メモID
    private long id;
    // タイトル
    private String title;
    // コンテンツ
    private String content;
}
