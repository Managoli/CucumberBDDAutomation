$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/functionalTest/selectProducts.feature");
formatter.feature({
  "line": 2,
  "name": "Select Products and Add to Chart",
  "description": "",
  "id": "select-products-and-add-to-chart",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3335628396,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Select Products and Add to Wish List",
  "description": "",
  "id": "select-products-and-add-to-chart;select-products-and-add-to-wish-list",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "I add four different products to my wish list",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "I view my wishlist table",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I find total four selected items in my Wishlist",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "I search for lowest price product",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I am able to add the lowest price item to my cart",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I am able to verify the item in my cart",
  "keyword": "Then "
});
formatter.match({
  "location": "selectProductsStepDefinition.i_add_four_different_products_to_my_wish_list()"
});
formatter.result({
  "duration": 12316353297,
  "status": "passed"
});
formatter.match({
  "location": "selectProductsStepDefinition.i_view_my_wishlist_table()"
});
formatter.result({
  "duration": 625286897,
  "status": "passed"
});
formatter.match({
  "location": "selectProductsStepDefinition.i_find_total_four_selected_items_in_my_Wishlist()"
});
formatter.result({
  "duration": 1098683108,
  "status": "passed"
});
formatter.match({
  "location": "selectProductsStepDefinition.i_search_for_lowest_price_product()"
});
formatter.result({
  "duration": 5187603128,
  "status": "passed"
});
formatter.match({
  "location": "selectProductsStepDefinition.i_am_able_to_add_the_lowest_price_item_to_my_cart()"
});
formatter.result({
  "duration": 2991352450,
  "status": "passed"
});
formatter.match({
  "location": "selectProductsStepDefinition.i_am_able_to_verify_the_item_in_my_cart()"
});
formatter.result({
  "duration": 215233716,
  "status": "passed"
});
formatter.after({
  "duration": 43749,
  "status": "passed"
});
});