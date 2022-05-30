$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event) {
	var button = $(event.relatedTarget);
	
	var codigoProduto = button.data('codigo');
	var nomeProduto = button.data('nome');
	
        alert(codigoProduto);
        
	var modal = $(this);
	var form = modal.find('form');
	var action = form.attr('action');
	if (!action.endsWith('/')) {
		action += '/';
	}
	form.attr('action', action + codigoProduto);
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir o produto <strong>' + nomeProduto + '</strong>?');
});
