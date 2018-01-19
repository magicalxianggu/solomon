<div class="showMode">
<div class="default_box" id="module0">
	<div class="views paddings noCont" id="module1">
			
		<gds:decor decorID="decorid-0" >
			<gds:module moduleID="moduleid-0">
			</gds:module>										
		</gds:decor>
								
	</div>
		
	<div class="views paddings noCont" id="module2">
			
		<gds:decor decorID="decorid-1" >
			<gds:module moduleID="moduleid-1" />
		</gds:decor>
			
	</div>
    <div class="views paddings noCont" id="module3">

        <!-- 标签页排版-->
        <div id="{tabsID}" class="tabs-wrap {tabsNO}">
            <div class="tab-header">
                <h3 class="tab-title">     </h3>
                <ul class="tab-list">
                    <li class="active"><a href="#{tabsID}-001">第一个标签</a></li>
                    <li><a href="#{tabsID}-002">第二个标签</a></li>
                </ul>
            </div>
            <div class="tab-content">
                <div class="tab-pane active" id="{tabsID}-001">

                    <gds:module moduleID="moduleid-1" />
                </div>
                <div class="tab-pane" id="{tabsID}-002">
                    <gds:decor decorID="decorid-1" >
                        <gds:module moduleID="moduleid-1" />
                    </gds:decor>

                </div>
            </div>
        </div>

    </div>
</div>
</div>
