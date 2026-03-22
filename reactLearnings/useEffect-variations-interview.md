
# React `useEffect` – All Variations Explained (Interview Ready)

This document explains **all `useEffect` dependency variations** with:
- When it runs (mount / update / unmount)
- Console logs to prove behavior
- Practical use cases
- Common pitfalls

---

## 1. `useEffect` WITHOUT Dependency Array

### Code
```jsx
useEffect(() => {
  console.log("Effect: runs after EVERY render");

  return () => {
    console.log("Cleanup: runs before next render and on unmount");
  };
});
```

### When it runs
| Event | Runs |
|------|------|
| Mount | ✅ |
| Any update | ✅ |
| Unmount | ❌ (cleanup runs) |

---

## 2. `useEffect` with EMPTY Dependency Array `[]`

### Code
```jsx
useEffect(() => {
  console.log("Effect: runs once on mount");

  return () => {
    console.log("Cleanup: runs on unmount");
  };
}, []);
```

### When it runs
| Event | Runs |
|------|------|
| Mount | ✅ |
| Update | ❌ |
| Unmount | ❌ (cleanup runs) |

---

## 3. `useEffect` with ONE Dependency `[count]`

```jsx
useEffect(() => {
  console.log("Effect: runs on mount and when count changes");

  return () => {
    console.log("Cleanup: before next count change or unmount");
  };
}, [count]);
```

---

## 4. `useEffect` with MULTIPLE Dependencies `[a, b]`

```jsx
useEffect(() => {
  console.log("Effect: runs when a or b changes");
}, [a, b]);
```

---

## 5. Object or Array Dependency (Common Mistake)

❌ Bad:
```jsx
useEffect(() => {}, [{ value: count }]);
```

✅ Good:
```jsx
const memoValue = useMemo(() => ({ value: count }), [count]);
useEffect(() => {}, [memoValue]);
```

---

## 6. Function Dependency

```jsx
const fetchData = useCallback(() => {
  // API call
}, []);

useEffect(() => {
  fetchData();
}, [fetchData]);
```

---

## 7. `useEffect` Without Cleanup

```jsx
useEffect(() => {
  console.log("Logging only");
}, [count]);
```

---

## 8. React Strict Mode (DEV only)

Effects run twice on mount to detect side effects.
This does NOT happen in production.

---

## Summary Table

| Dependency Array | Effect Runs | Cleanup Runs |
|-----------------|-------------|--------------|
| No array | Every render | Before next + unmount |
| `[]` | Mount only | Unmount |
| `[x]` | Mount + x change | Before x change + unmount |
| `[a, b]` | Mount + a/b change | Before a/b change + unmount |

---

## Interview One-Liner

> Without dependencies, `useEffect` runs after every render. With an empty array, it runs only on mount and cleanup on unmount. With dependencies, it runs when those values change.

