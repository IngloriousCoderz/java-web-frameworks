$(function () {
	$('ul').on('click', ':checkbox', function () {
		var id = $(this).siblings('input[name="id"]').val();
		$.get('toggle-done?id=' + id);
	});
});
