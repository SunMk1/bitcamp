package com.bitcamp.mylist;

public class ArrayList2 {

  static Todo[] list = new Todo[5];
  static int size = 0;

  // 기존 배열을 새 배열에 복사한다.
  static Todo[] grow() {
    Todo[] arr = new Todo[newLength()];
    copy(list, arr);
    return arr;
  }

  // 배열을 크기를 늘린다.
  static int newLength() {
    return list.length + (list.length >> 1);
  }

  // 배열을 복사한다.
  static void copy(Todo[] source, Todo[] target) {
    // 개발자가 잘못 사용할 것을 대비한 코드를 추가한다.
    int length = source.length;
    if (target.length < source.length) {
      length = target.length;
    }
    for (int i = 0; i < length; i++) {
      target[i] = source[i];
    }
  }

  //배열에서 지정한 항목을 삭제한다.
  static Todo remove(int index) {
    Todo old = list[index];
    for (int i = index + 1; i < size; i++) {
      list[i-1] = list[i];
    }
    size--;
    return old;
  }

  // 기존 배열의 목록을 새 배열에 담는다.
  static Todo[] toArray() {
    Todo[] arr = new Todo[size];
    for (int i = 0; i < size; i++) {
      arr[i] = list[i];
    }
    return arr;
  }

  static void add(Todo contact) {
    // 배열이 꽉 찼는지 검사.
    if (size == list.length) {
      // 꽉 찼을 경우 매서드 실행.
      list = grow();
    }
    list[size++] = contact;
  }

  // 특정 위치에 배열의 값을 변경한다.
  // 변경전 값을 리턴
  static Todo set(int index, Todo contact) {
    if (index < 0 || index >= size) {
      return null;
    }
    Todo old = list[index];
    list[index] = contact;
    return old;
  }
}
