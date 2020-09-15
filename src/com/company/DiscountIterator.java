package com.company;

import java.util.List;

public class DiscountIterator implements Iterator {
    
    private List<Discount> discountList;
    private int position = 0;

    public DiscountIterator(List<Discount> discountList) {
        this.discountList = discountList;
    }

    @Override
    public boolean hasNext() {
        return position < discountList.size();
    }

    @Override
    public Discount next() {
        Discount discount = discountList.get(position);
        position ++;
        return discount;
    }
}
