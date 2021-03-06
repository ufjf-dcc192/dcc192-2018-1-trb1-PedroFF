<%@page import="ufjf.br.dcc192.ListaDeMesas"%>
<%@page import="ufjf.br.dcc192.Pedido"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ufjf.br.dcc192.Mesa"%>
<%@include file="jspf/cabecalho.jspf" %>
<%Mesa mesa = (Mesa) request.getAttribute("mesa");
    ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
    pedidos = mesa.getPedidos();
%>
<table class="table table-striped">
    <thead>
        <tr>
            <th scope="col">Pedido</th>
            <th scope="col">Status</th>
            <th scope="col">Edi��o de Pedido</th>
            <th scope="col">Fechar Pedido</th>
            <th scope="col">Ver Pedido</th>
        </tr>
    </thead>
    <tbody>
        <%for (int i = 0; i < pedidos.size(); i++) {%>
        <tr>
            <td><%=i+1%></td>
            <td><%=pedidos.get(i).getConta() ? "Aberto" : "Fechado"%></td>
            <td><a href="editar-pedido.html?mesa=<%= ListaDeMesas.getInstance().indexOf(mesa) %>&pedido=<%=i%>">Editar Pedido</a></td>
            <td><a href="fechar-pedido.html?mesa=<%= ListaDeMesas.getInstance().indexOf(mesa) %>&pedido=<%=i%>">Fechar Pedido</a></td>
            <td><a href="relatorio-pedido.html?mesa=<%= ListaDeMesas.getInstance().indexOf(mesa) %>&pedido=<%=i%>">Ver Pedido</a></td>
        </tr>
        <%}%>
        <tr>
            <td colspan="5"><a href="novo-pedido.html?mesa=<%= ListaDeMesas.getInstance().indexOf(mesa) %>">Novo Pedido</a></td>
        </tr>
    </tbody>
</table>



<%@include file="jspf/rodape.jspf" %>