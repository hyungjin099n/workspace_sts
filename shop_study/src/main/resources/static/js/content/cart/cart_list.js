setFinalPrice();

//총 가격 계산 함수
function setFinalPrice(){
    //체크된 장바구니 상품의 총 가격을 모두 더해서 계산.
    //클래스가 chk인 태그 중에서 체크가 된 태그만 선택
    const chks = document.querySelectorAll('.chk:checked');

    let finalPrice = 0;
    chks.forEach(function(chk, i){
        //chk 각각의 같은 행에 있는 총 가격 데이터 찾아가기
        const strPrice = chk.closest('tr').children[5].textContent;

        //정규식을 사용해서 쉼표와 원화표시를 제거
        const regex = /[^0-9]/g;
        const price = parseInt(strPrice.replace(regex, ''));// ￦20,000 -> 20000
        finalPrice = finalPrice + price;
    });

    document.querySelector('#finalPrice-span').textContent = finalPrice.toLocaleString();
}

//제목줄 체크 박스 체크 및 해제 시 모든 체크박스 체크 및 해제
function checkAll(){
    const chkAll = document.querySelector('#chkAll');
    const chks = document.querySelectorAll('.chk');

    if(chkAll.checked){
        for(const chk of chks){
            chk.checked = true;
        }
    }
    else{
        for(const chk of chks){
            chk.checked = false;
        }
    }

    setFinalPrice();

}


//삭제버튼 클릭 시 장바구니에서 삭제
function deleteCart(cartCode){
    if(confirm('선택한 상품을 장바구니에서 삭제할까요?')){
        location.href = `/cart/deleteCart?cartCode=${cartCode}`;
    }
}