<div class="jx_menu">
	<div class="xaccordion parent_menu" id="jx_menu">
		<ul class="xtemplate">
			<li class="xparent">
				<span class="parent">{name}</span>
				<ul class="xson">
					<li class='son' data-id="{id}" data-url="${adminPath}{url}">{name}</li>
				</ul>
			</li>
		</ul>
	</div>
	<div class="son_menu">
		<div class="son_menu_title"></div>
		<div class="xaccordion" id="jx_son_menu">
			<ul class="xtemplate">
				<li class="xparent" data-id="{id}" data-url="${adminPath}{url}">
					<span class="parent">{name}</span>
					<ul class="xson">
						<li class='son' data-url='${adminPath}{url}'>{name}</li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</div>