# Template Layout Guide

## Overview

The Operations Portal now uses a centralized layout system to reduce maintenance and ensure consistency across all pages. The navigation bar and common elements are defined in `layout.html` and reused across all templates.

## How It Works

### 1. Layout Structure

The `layout.html` file contains:
- **HTML Fragment**: `th:fragment="html"` - The complete HTML structure
- **Head Fragment**: `th:fragment="head"` - CSS, meta tags, and title
- **Body Fragment**: `th:fragment="body"` - Navigation sidebar and main content area

### 2. Creating New Pages

To create a new page, use this template structure:

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" th:replace="layout :: html">
<head th:replace="layout :: head"></head>
<body th:replace="layout :: body">
    <!-- Content fragment -->
    <div th:fragment="content">
        <!-- Your page content goes here -->
        <div class="row">
            <div class="col-12">
                <div class="card shadow">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">Your Page Title</h6>
                    </div>
                    <div class="card-body">
                        <!-- Your content -->
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Scripts fragment -->
    <div th:fragment="scripts">
        <script th:inline="javascript">
            // Your JavaScript code goes here
            $(document).ready(function() {
                console.log('Page loaded');
            });
        </script>
    </div>
</body>
</html>
```

### 3. Key Benefits

#### ✅ **Centralized Navigation**
- All navigation links are defined in one place (`layout.html`)
- Adding new menu items requires updating only one file
- Consistent navigation across all pages

#### ✅ **Active Link Highlighting**
- Navigation automatically highlights the current page
- Uses `th:classappend` with `#httpServletRequest.requestURI`
- No manual maintenance required

#### ✅ **Consistent Styling**
- CSS styles are defined once in the layout
- All pages inherit the same look and feel
- Easy to update global styles

#### ✅ **Reduced Maintenance**
- No need to duplicate navigation code
- Changes to layout apply to all pages automatically
- Faster development of new pages

### 4. Navigation Structure

The layout includes these sections:

#### Dashboard Section
- Market Open (`/market-open`)
- System Health (`/system-health`)
- Inventory (`/inventory`)

#### Dry Run Section
- Report (`/dry-run/report`)
- Linux (`/dry-run/linux`)
- Windows (`/dry-run/windows`)

#### Break Glass Section
- Traffic Controller (`/break-glass/traffic-controller`)
- DR Ops (`/break-glass/dr-ops`)
- Emergency Ops (`/break-glass/emergency-ops`)

#### DoD Section
- Config Review (`/dod/config-review`)
- Kafka (`/dod/kafka`)
- Certificate (`/dod/certificate`)
- Service Accounts (`/dod/service-accounts`)
- Firewall (`/dod/firewall`)

### 5. Adding New Navigation Items

To add a new navigation item:

1. **Update `layout.html`**:
   ```html
   <li class="nav-item">
       <a class="nav-link" th:classappend="${#httpServletRequest.requestURI == '/your-new-path' ? 'active' : ''}" th:href="@{/your-new-path}">
           <i class="fas fa-your-icon me-2"></i>
           Your New Page
       </a>
   </li>
   ```

2. **Add controller mapping** in `DashboardController.java`:
   ```java
   @GetMapping("/your-new-path")
   public String yourNewPage(Model model) {
       model.addAttribute("title", "Your New Page");
       return "your-new-page";
   }
   ```

3. **Create the template** using the structure above

### 6. Example: Creating a New Page

Here's a complete example for creating a "System Status" page:

#### Step 1: Add to layout.html
```html
<li class="nav-item">
    <a class="nav-link" th:classappend="${#httpServletRequest.requestURI == '/system-status' ? 'active' : ''}" th:href="@{/system-status}">
        <i class="fas fa-server me-2"></i>
        System Status
    </a>
</li>
```

#### Step 2: Add controller mapping
```java
@GetMapping("/system-status")
public String systemStatus(Model model) {
    model.addAttribute("title", "System Status");
    return "system-status";
}
```

#### Step 3: Create system-status.html
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" th:replace="layout :: html">
<head th:replace="layout :: head"></head>
<body th:replace="layout :: body">
    <!-- Content fragment -->
    <div th:fragment="content">
        <div class="row">
            <div class="col-12">
                <div class="card shadow">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">System Status</h6>
                    </div>
                    <div class="card-body">
                        <p>Your system status content here...</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Scripts fragment -->
    <div th:fragment="scripts">
        <script th:inline="javascript">
            $(document).ready(function() {
                console.log('System Status page loaded');
            });
        </script>
    </div>
</body>
</html>
```

### 7. Migration Guide

To migrate existing self-contained templates to use the layout:

1. **Remove duplicate HTML structure** (head, body, navigation)
2. **Keep only the content** inside the `th:fragment="content"` div
3. **Move scripts** to the `th:fragment="scripts"` div
4. **Add the layout references** at the top

### 8. Best Practices

- ✅ Always use the layout template for new pages
- ✅ Keep page-specific CSS in the layout's style section
- ✅ Use Bootstrap classes for consistent styling
- ✅ Include page-specific JavaScript in the scripts fragment
- ✅ Test navigation highlighting works correctly
- ✅ Keep content focused and avoid duplicating layout elements

### 9. Troubleshooting

#### Navigation not highlighting correctly?
- Check the URL path matches exactly in `th:classappend`
- Ensure the controller mapping returns the correct template

#### Styles not applying?
- Verify CSS is in the layout's `<style>` section
- Check for conflicting CSS rules

#### JavaScript not working?
- Ensure jQuery is loaded (included in layout)
- Check console for errors
- Verify scripts are in the `th:fragment="scripts"` div

This centralized layout system makes the Operations Portal much easier to maintain and ensures consistency across all pages! 