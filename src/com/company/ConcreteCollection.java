package com.company;

public class ConcreteCollection implements IterableCollection{
    @Override
    /**
     * Anaokulunun sahip olduğu indirim listesinde ilerlemeyi sağlayan iterator sınıfının objesini oluşturur.
     * @return
     */
    public Iterator createDiscountIterator(IPreschoolAccess preschool) {
        return new DiscountIterator(Database.setDiscountByPreschool(preschool) );
    }
}
