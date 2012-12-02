
package com.example.robolectrictest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;

import android.widget.TextView;

import com.example.robolectrictest.ClassForTest;
import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.RobolectricTestRunner;

import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.*;

@PrepareForTest(com.example.robolectrictest.ClassForTest.class)
@PowerMockIgnore({"com.xtremelabs.*", "android.*"})
@RunWith(RobolectricTestRunner.class)
public class TestCases {
	@Rule
	public PowerMockRule rule = new PowerMockRule();

	@Test
	public void FirstTest() {
		TargetActivity target = new TargetActivity();
		target.onCreate(null);
		TextView view = (TextView) target.findViewById(R.id.hello_text);
		assertEquals(Robolectric.application.getString(R.string.hello_world),
				view.getText());
	}

	@Test
	public void PowerMockTest() throws Exception {
		ClassForTest mock = mock(ClassForTest.class);
		when(mock.getString()).thenReturn("PowerMocked!!");
		whenNew(ClassForTest.class).withNoArguments().thenReturn(mock);

		TargetActivity target = new TargetActivity();
		target.onCreate(null);
		TextView view = (TextView) target.findViewById(R.id.hello_text);
		assertEquals("PowerMocked!!", view.getText());
	}
}
