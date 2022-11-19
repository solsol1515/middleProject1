$(function(){
	/*
	const urlParams = new URL(location.href).searchParams;

	const goods_type = urlParams.get('goods_type');
	const goods_sort = urlParams.get('goods_sort');
	
	// remove active
	$('.goods_type-section a').removeClass('active');
	$('.goods_sort-section a').removeClass('active');
	
	// add class
	$('.goods_type-section a[name=' + goods_type + ']').addClass('active');
	$('.goods_sort-section a[name=' + goods_sort + ']').addClass('active');
	*/

	// 주종 nav-bar를 클릭했을 때
	$('.goods_type-section a').click(function(){
		
		// goods_type에 주종, goods_sort에 정렬 순서를 문자열로 담기
		let goods_type = $(this).attr('name');		
		let goods_sort = $('.goods_sort-section a.active').attr('name');
		
		// controller 로 보내기
		window.location.href="shop.do?goods_type=" + goods_type + "&goods_sort=" + goods_sort;
		
	});	// end of 주종 클릭
	
	// 정렬 순서 nav-bar를 클릭했을 때
	$('.goods_sort-section a').click(function(){
	
		// goods_type에 주종, goods_sort에 정렬 순서를 문자열로 담기
		let goods_sort = $(this).attr('name');
		let goods_type = $('.goods_type-section a.active').attr('name');
		
		// controller 로 보내기
		window.location.href="shop.do?goods_type=" + goods_type + "&goods_sort=" + goods_sort;
		
	});	// end of 정렬 순서

});	// end of $(function())