/** サイドバーのフォーカス切り替え */
window.onload = function() {
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

if (location.href.includes('edit') || location.href.includes('create')) {
  const editInput = document.querySelector('.form-title input#title');
  editInput.onkeydown = function (e) {
    if (e.key === 'Enter') {
      return false;
    }
  }
}
