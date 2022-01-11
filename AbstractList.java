package myvector.myvector;

import java.util.*;

public abstract class AbstractList extends AbstractCollection implements List {
    protected AbstractList() { }

    public boolean add(Object o) {
        add(size(), o);
        return true;
    }

    public abstract Object get(int index);

    public Object set(int index, Object element) {
        throw new UnsupportedOperationException();
    }

    public void add(int index, Object element) {
        throw new UnsupportedOperationException();
    }

    public Object remove(int index) {
        throw new UnsupportedOperationException();
    }

    public int indexOf(Object o) {
        ListIterator e = listIterator();
        if (o == null) {
            while (e.hasNext()) {
                if (e.next() == null) {
                    return e.previousIndex();
                }
            }
        } else {
            while (e.hasNext()) {
                if (o.equals(e.next())) {
                    return e.previousIndex();
                }
            }
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        ListIterator e = listIterator(size());
        if (o == null) {
            while (e.hasPrevious()) {
                if (e.previous() == null) {
                    return e.nextIndex();
                }
            }
        } else {
            while (e.hasPrevious()) {
                if (o.equals(e.previous())) {
                    return e.nextIndex();
                }
            }
        }
        return -1;
    }

    public void clear() {
        removeRange(0, size());
    }

    public boolean addAll(int index, Collection c) {
        boolean modified = false;
        Iterator e = c.iterator();
        while (e.hasNext()) {
            add(index++, e.next());
            modified = true;
        }
        return modified;
    }

    public Iterator iterator() {
        return new Itr();
    }

    public ListIterator listIterator() {
        return listIterator(0);
    }

    public ListIterator listIterator(final int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

        return new ListItr(index);
    }

    private class Itr implements Iterator {
        int cursor = 0;
        int lastRet = -1;
        int expectedModCount = modCount;

        public boolean hasNext() {
            return cursor != size();
        }

        public Object next() {
            try {
                Object next = get(cursor);
                checkForComodification();
                lastRet = cursor++;
                return next;
            } catch (IndexOutOfBoundsException e) {
                checkForComodification();
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            if (lastRet == -1) {
                throw new IllegalStateException();
            }
            checkForComodification();
            try {
                AbstractList.this.remove(lastRet);
                if (lastRet < cursor) {
                    cursor--;
                }
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }
        }

        final void checkForComodification() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    private class ListItr extends Itr implements ListIterator {
        ListItr(int index) {
            cursor = index;
        }

        public boolean hasPrevious() {
            return cursor != 0;
        }

        public Object previous() {
            try {
                int i = cursor - 1;
                Object previous = get(i);
                checkForComodification();
                lastRet = cursor = i;
                return previous;
            } catch (IndexOutOfBoundsException e) {
                checkForComodification();
                throw new NoSuchElementException();
            }
        }

        public int nextIndex() {
            return cursor;
        }

        public int previousIndex() {
            return cursor - 1;
        }

        public void set(Object o) {
            if (lastRet == -1) {
                throw new IllegalStateException();
            }
            checkForComodification();

            try {
                AbstractList.this.set(lastRet, o);
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }
        }

        public void add(Object o) {
            checkForComodification();
            try {
                AbstractList.this.add(cursor++, o);
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }
        }
    }

    public List subList(int fromIndex, int toIndex) {
        return (this instanceof RandomAccess ?
                new RandomAccessSubList(this, fromIndex, toIndex) :
                new SubList(this, fromIndex, toIndex));
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof List)) {
            return false;
        }
        ListIterator e1 = listIterator();
        ListIterator e2 = ((List) o).listIterator();
        while (e1.hasNext() && e2.hasNext()) {
            Object o1 = e1.next();
            Object o2 = e2.next();
            if (!(o1 == null ? o2 == null : o1.equals(o2))) {
                return false;
            }
        }
        return !(e1.hasNext() || e2.hasNext());
    }

    public int hashCode() {
        int hashCode = 1;
        Iterator i = iterator();
        while (i.hasNext()) {
            Object obj = i.next();
            hashCode = 31 * hashCode + (obj == null ? 0 : obj.hashCode());
        }
        return hashCode;
    }

    protected void removeRange(int fromIndex, int toIndex) {
        ListIterator it = listIterator(fromIndex);
        for (int i = 0, n = toIndex - fromIndex; i < n; i++) {
            it.next();
            it.remove();
        }
    }

    protected transient int modCount = 0;
}
class SubList extends AbstractList {
    private AbstractList l;
    private int offset;
    private int size;
    private int expectedModCount;

    SubList(AbstractList list, int fromIndex, int toIndex) {
        if (fromIndex < 0) {
            throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
        }
        if (toIndex > list.size()) {
            throw new IndexOutOfBoundsException("toIndex = " + toIndex);
        }
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException("fromIndex(" + fromIndex +
                    ") > toIndex(" + toIndex + ")");
        }
        l = list;
        offset = fromIndex;
        size = toIndex - fromIndex;
        expectedModCount = l.modCount;
    }

    public Object set(int index, Object element) {
        rangeCheck(index);
        checkForComodification();
        return l.set(index + offset, element);
    }

    public Object get(int index) {
        rangeCheck(index);
        checkForComodification();
        return l.get(index + offset);
    }

    public int size() {
        checkForComodification();
        return size;
    }

    public void add(int index, Object element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        checkForComodification();
        l.add(index + offset, element);
        expectedModCount = l.modCount;
        size++;
        modCount++;
    }

    public Object remove(int index) {
        rangeCheck(index);
        checkForComodification();
        Object result = l.remove(index + offset);
        expectedModCount = l.modCount;
        size--;
        modCount++;
        return result;
    }

    protected void removeRange(int fromIndex, int toIndex) {
        checkForComodification();
        l.removeRange(fromIndex + offset, toIndex + offset);
        expectedModCount = l.modCount;
        size -= (toIndex - fromIndex);
        modCount++;
    }

    public boolean addAll(Collection c) {
        return addAll(size, c);
    }

    public boolean addAll(int index, Collection c) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size);
        }
        int cSize = c.size();
        if (cSize == 0) {
            return false;
        }
        checkForComodification();
        l.addAll(offset + index, c);
        expectedModCount = l.modCount;
        size += cSize;
        modCount++;
        return true;
    }

    public Iterator iterator() {
        return listIterator();
    }

    public ListIterator listIterator(final int index) {
        checkForComodification();
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size);
        }
        return
                new ListIterator() {
                    private ListIterator i = l.listIterator(index + offset);

                    public boolean hasNext() {
                        return nextIndex() < size;
                    }

                    public Object next() {
                        if (hasNext()) {
                            return i.next();
                        } else {
                            throw new NoSuchElementException();
                        }
                    }

                    public boolean hasPrevious() {
                        return previousIndex() >= 0;
                    }

                    public Object previous() {
                        if (hasPrevious()) {
                            return i.previous();
                        } else {
                            throw new NoSuchElementException();
                        }
                    }

                    public int nextIndex() {
                        return i.nextIndex() - offset;
                    }

                    public int previousIndex() {
                        return i.previousIndex() - offset;
                    }

                    public void remove() {
                        i.remove();
                        expectedModCount = l.modCount;
                        size--;
                        modCount++;
                    }

                    public void set(Object o) {
                        i.set(o);
                    }

                    public void add(Object o) {
                        i.add(o);
                        expectedModCount = l.modCount;
                        size++;
                        modCount++;
                    }
                };
    }

    public List subList(int fromIndex, int toIndex) {
        return new SubList(this, fromIndex, toIndex);
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index +
                    ",Size: " + size);
        }
    }

    private void checkForComodification() {
        if (l.modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }
}
class RandomAccessSubList extends SubList implements RandomAccess {

    RandomAccessSubList(AbstractList list, int fromIndex, int toIndex) {
        super(list, fromIndex, toIndex);
    }

    public List subList(int fromIndex, int toIndex) {
        return new RandomAccessSubList(this, fromIndex, toIndex);
    }
}

