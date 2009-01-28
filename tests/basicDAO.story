scenario "Non-Gold level customer with \$100 or more" , {
  given "a non-Gold level customer"
  when "they have \$100 or more in their shopping cart"
  then "they should receive a \$10 discount"
  and "they should be emailed a coupon"
}