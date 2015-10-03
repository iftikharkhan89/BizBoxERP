// JavaScript Document
var pixelset=0;
var maxHeight=0;
var innerHeight;
function nextMenu()
{
    innerHeight = document.getElementById('content').offsetHeight;
    innerHeight = innerHeight - 640;
    if ( maxHeight < innerHeight)
    {
        maxHeight = maxHeight + 458;
        pixelset = pixelset - 458;
        document.getElementById("content").style.marginTop = pixelset + "px";
        document.getElementById("Prev-Button").style.backgroundImage = "url(resources/images/prev-icon.png)";
    }
    else {
        document.getElementById("Next-Button").style.display = "none"
    }
}
function PrevMenu()
{
    if ( pixelset < 0 )
    {
        maxHeight = maxHeight - 458;
        pixelset = pixelset + 458;
        document.getElementById("content").style.marginTop = pixelset + "px";
        document.getElementById("Next-Button").style.display = "block"
    }
    else {
        document.getElementById("Prev-Button").style.backgroundImage = "none"
    }
}