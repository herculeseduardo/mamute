$(".vote-option").bind("click", function() {
	if($(this).hasClass("voted")){
		$(this).closest(".vote").find(".already-voted").show();
	}else{
		$(this).closest(".vote").find(".already-voted").hide();
		vote($(this));
	}
});

function vote(link) {
	var vote = link.data("value");
	var type = link.data("type");
	var id = link.data("id");
	var params = "/"+ type +"/"+ id +"/"+ vote;
	$.ajax(""+ params, {
		success: function() { voteSuccess(link) },
		error: voteError,
		method: "POST"
	});
}

function highlight(link) {
	link.addClass("voted").siblings().removeClass("voted");
}

function voteSuccess(link) {
	highlight(link);
}

function voteError() {
	console.log("falhou");
}
