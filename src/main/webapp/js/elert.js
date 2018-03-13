/**
 * Created by 57056 on 2018/1/23.
 */

function hideAlert(a){
    if(a.innerHTML.length!=0){
        setTimeout(function aa() {
            a.innerHTML="";
        },2000);
    }
}
