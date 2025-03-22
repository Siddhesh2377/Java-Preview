# 🚀 Java-Preview

**Java-Preview** is a lightweight engine designed to improve the efficiency of the [Block-IDE](https://github.com/your-block-ide-link), enabling users to **instantly preview minimal UI components and layouts** written in Java. It helps developers visualize their interface without running a full Android build, making prototyping much faster and more intuitive.

---

## 🔧 How It Works

1. **XML UI Definitions** and Java references (drawables, animations, etc.) are converted into a simplified **JSON layout structure**.
2. The JSON is parsed using a custom data model (`UIElement`) with help from the **Gson** library.
3. A dynamic rendering engine (`PreviewView`) decodes and displays the UI elements based on the provided JSON.

---

## 🧩 Sample JSON Input

```json
{
  "id": "root",
  "type": "LinearLayout",
  "props": {
    "width": "fill",
    "height": "fill",
    "background-color": "#66FFFF",
    "orientation": "vertical",
    "items-align": "top-right"
  },
  "child": {
    "id": "btn1",
    "type": "Button",
    "props": {
      "width": "wrap",
      "height": "wrap",
      "text": "Click Me"
    }
  }
}
```

---

## 👁️ Live Preview

All JSON layouts are rendered on-the-fly using the custom `PreviewView`:

```java
PreviewView preview = new PreviewView(context);
preview.feedData(jsonString); // Automatically parses and renders the UI
```

The `PreviewView` is a custom `ViewGroup` that parses layout trees and applies measurements, layout rules, and rendering logic dynamically.

---

## 📸 Screenshot - Preview

![Preview Screenshot](https://github.com/user-attachments/assets/8bd8f151-d770-41b8-9529-ddc0fa57b4ec)

