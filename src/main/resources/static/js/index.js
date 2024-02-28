$(function () {
  addClassActive(window.location.pathname);
});

function addClassActive(pathname = "") {
  $.each($("#navbar").find("a"), function () {
    if ($(this).attr("href") == pathname) {
      $(this).addClass("active");
    } else {
      $(this).removeClass("active");
    }
  });
}
