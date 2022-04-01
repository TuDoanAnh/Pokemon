window.addEventListener("load", function(){
    const slider = document.querySelector(".slider")
    const sliderDots = document.querySelectorAll(".slider-dots")
    const sliderMain = document.querySelector(".slider-main")
    const sliderItems = document.querySelectorAll(".slider-items")
    const prevBtn = document.querySelector(".slider-prev")
    const nextBtn = document.querySelector(".slider-next")
    const dots = document.querySelectorAll(".slider-dot-item")
    const imgWidth = sliderItems[0].offsetWidth
    const sliderLength = sliderItems.length
    const menuItems = document.querySelectorAll(".menu-items")
    let position = 0;
    let index = 0;
    let temp = 0;
    this.setInterval(function(){
        if(temp===8) temp=0;
        changeDots(dots[temp++]);
    }, 3000)
    nextBtn.addEventListener("click", function(){
        changeImg(1);
    })
    prevBtn.addEventListener("click", function(){
        changeImg(2);
    })
    for(var value of dots){
        value.addEventListener("click", function(){
            changeDots(this);
        })
    }
    for(var value of menuItems){
        value.addEventListener("click", function(){
            let activeTemp = document.querySelector(".active1");
            activeTemp.classList.remove("active1");
            this.classList.add("active1");     
        })
    }
    function changeImg(parameter){
        if(parameter===1){
            index++;
            if(index >= sliderLength) {
                index--;
                return;
            }
            position = position - imgWidth;
            sliderMain.style = `transform: translateX(${position}px)`;
            dots[index].classList.add("active");
            dots[index-1].classList.remove("active");
        }else{
            index--;
            if(index < 0) {
                index++;
                return;
            }
            position = position + imgWidth;
            sliderMain.style = `transform: translateX(${position}px)`;
            dots[index].classList.add("active");
            dots[index+1].classList.remove("active");
        }
    }
    function changeDots(value){
        let activeItems = document.querySelector(".active");
        let i = activeItems.getAttribute('data-index');
        let n = Number(value.getAttribute('data-index'));
        if( n < i){ 
            position = position + (i - n)*imgWidth;
            sliderMain.style = `transform: translateX(${position}px)`;
            value.classList.add("active");
            activeItems.classList.remove("active");
            index = n;
        }else if( i < n){
            position = position - (n - i)*imgWidth;
            sliderMain.style = `transform: translateX(${position}px)`;
            value.classList.add("active");
            activeItems.classList.remove("active");
            index=n;
        }else return;
    }
    }); 