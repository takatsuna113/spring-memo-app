/** サイドバーのフォーカス切り替え */
if (location.href.includes('detail')) {
  window.onload = function () {
    const currentUrl = location.href;
    // activeクラスを追加するクラスを取得
    const sidebar = document.querySelectorAll('.sidebar-items');
    sidebar.forEach((link) => {
      // 各コンテンツの詳細リンクのhref属性を取得
      const activeUrl = link.children[1].children[0].href;
      // 開いているURLと詳細リンクを押したコンテンツが一致している場合、activeクラスを追加
      if (currentUrl === activeUrl) {
        link.classList.add('active');
      }
    });
  }
}

// 編集・新規作成画面でEnterによるフォーム送信を制御
if (location.href.includes('edit') || location.href.includes('create')) {
  const editInput = document.querySelector('.form-title input#title');
  // inputタグ内ではEnter押下時の送信処理を禁止
  editInput.onkeydown = function (e) {
    if (e.key === 'Enter') {
      return false;
    }
  }
}

// 個別の完全削除モーダル表示
if (location.href.includes('garbage')) {
  const memoList = document.querySelectorAll('.remove');
  memoList.forEach((memo) => {
    memo.addEventListener('click', () => {
      // 「完全に削除」が押された箇所のメモIDをモーダルに渡す
      rmModalOpen(memo.classList[1]);
    })
  });
  // モーダル表示
  const rmModalOpen = (memoId) => {    
    const rmModal = document.querySelector('.remove-confirm');
    // href属性(リクエストURL)にidを付与するaタグを取得
    const rmTargetAnchor = rmModal.children[0].children[2].children[0];
    rmTargetAnchor.setAttribute('href', `remove/${memoId}`);
    rmModal.style.visibility = 'visible';
    rmModal.style.zIndex = '100';
  }
}

// モーダル非表示
const rmModalClose = () => {
  const rmModal = document.querySelector('.remove-confirm');
  rmModal.style.visibility = 'hidden';
  rmModal.style.zIndex = '-1';
}

// ゴミ箱を空にするモーダル表示
const emptyModalOpen = () => {
  const emptyModal = document.querySelector('.empty-confirm');
  const rmTargetAnchor = emptyModal.children[0].children[2].children[0];
  rmTargetAnchor.setAttribute('href', `removeAll/`);
  emptyModal.style.visibility = 'visible';
  emptyModal.style.zIndex = '100';
}

// ゴミ箱を空にするモーダル非表示
const emptyModalClose = () => {
  const emptyModal = document.querySelector('.empty-confirm');
  emptyModal.style.visibility = 'hidden';
  emptyModal.style.zIndex = '-1';
}
