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
            <ul class="tab-list">
                <li class="active"><a href="#home">Home</a></li>
                <li><a href="#profile">Profile</a></li>
                <li><a href="#messages">Messages</a></li>
                <li><a href="#settings">Settings</a></li>
            </ul>
            <div class="tab-content">
                <div class="tab-pane active" id="home">
						<gds:module moduleID="moduleid-1" />
				</div>
                <div class="tab-pane" id="profile">
                    <gds:decor decorID="decorid-1" >
                        <gds:module moduleID="moduleid-1" />
                    </gds:decor>
				</div>
                <div class="tab-pane" id="messages">
                        <gds:module moduleID="moduleid-1" />
				</div>
                <div class="tab-pane" id="settings">
                    <gds:decor decorID="decorid-1">
                        <gds:module moduleID="moduleid-1" />
                    </gds:decor>
				</div>
            </div>
        </div>
    </div>
</div>
</div>
