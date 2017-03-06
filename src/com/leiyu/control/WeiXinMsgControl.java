package com.leiyu.control;

import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.jfinal.MsgController;
import com.jfinal.weixin.sdk.msg.in.InImageMsg;
import com.jfinal.weixin.sdk.msg.in.InLinkMsg;
import com.jfinal.weixin.sdk.msg.in.InLocationMsg;
import com.jfinal.weixin.sdk.msg.in.InNotDefinedMsg;
import com.jfinal.weixin.sdk.msg.in.InShortVideoMsg;
import com.jfinal.weixin.sdk.msg.in.InTextMsg;
import com.jfinal.weixin.sdk.msg.in.InVideoMsg;
import com.jfinal.weixin.sdk.msg.in.InVoiceMsg;
import com.jfinal.weixin.sdk.msg.in.event.InCustomEvent;
import com.jfinal.weixin.sdk.msg.in.event.InFollowEvent;
import com.jfinal.weixin.sdk.msg.in.event.InLocationEvent;
import com.jfinal.weixin.sdk.msg.in.event.InMassEvent;
import com.jfinal.weixin.sdk.msg.in.event.InMenuEvent;
import com.jfinal.weixin.sdk.msg.in.event.InMerChantOrderEvent;
import com.jfinal.weixin.sdk.msg.in.event.InNotDefinedEvent;
import com.jfinal.weixin.sdk.msg.in.event.InPoiCheckNotifyEvent;
import com.jfinal.weixin.sdk.msg.in.event.InQrCodeEvent;
import com.jfinal.weixin.sdk.msg.in.event.InShakearoundUserShakeEvent;
import com.jfinal.weixin.sdk.msg.in.event.InSubmitMemberCardEvent;
import com.jfinal.weixin.sdk.msg.in.event.InTemplateMsgEvent;
import com.jfinal.weixin.sdk.msg.in.event.InUpdateMemberCardEvent;
import com.jfinal.weixin.sdk.msg.in.event.InUserPayFromCardEvent;
import com.jfinal.weixin.sdk.msg.in.event.InUserViewCardEvent;
import com.jfinal.weixin.sdk.msg.in.event.InVerifyFailEvent;
import com.jfinal.weixin.sdk.msg.in.event.InVerifySuccessEvent;
import com.jfinal.weixin.sdk.msg.in.event.InWifiEvent;
import com.jfinal.weixin.sdk.msg.in.speech_recognition.InSpeechRecognitionResults;
import com.jfinal.weixin.sdk.msg.out.OutNewsMsg;
import com.jfinal.weixin.sdk.msg.out.OutTextMsg;
import com.leiyu.service.NewsService;

public class WeiXinMsgControl extends MsgController{
	@Override
	public ApiConfig getApiConfig() {
		// TODO Auto-generated method stub
		ApiConfig ap=new ApiConfig();
		ap.setAppId("wx2506f9bfa04e81ff");
		ap.setToken("JavaJfinal");
		ap.setAppSecret("69b60f7aca54f806000bb7378fed98b5");
		ap.setEncryptMessage(false);
		ap.setEncodingAesKey("P7lZ1cZ99gBq9AfNjyaPdh0eN2lIa21dgdSSCheEyyK");
		return ap;
	}

	@Override
	protected void processInTextMsg(InTextMsg inTextMsg) {
		// TODO Auto-generated method stub
		String mg=inTextMsg.getContent().trim();
		if(mg.equalsIgnoreCase("����")){
			OutTextMsg out=new OutTextMsg(inTextMsg);
			out.setContent("����Իظ����飬���ŵȹؼ��ʡ�������������");
			render(out);
		}
		else if(mg.equalsIgnoreCase("����")){
			
			OutNewsMsg news=new OutNewsMsg(inTextMsg);
			news.addNews(new NewsService().get_mynews());
			render(news);
		}
		else if(mg.equalsIgnoreCase("����")){
			String str1="http://img1.tplm123.com/2014/08/28/36715/14368643015328.jpg";
			String str="http://t2.shuqi.com/#!/ac/in/ct/def/usn/guest1479039259323/";
			OutNewsMsg outnew=new OutNewsMsg(inTextMsg);
			outnew.addNews("�������","������ѣ��Թ���֮��", str1, str);
			render(outnew);
		}else{
			OutTextMsg out=new OutTextMsg(inTextMsg);
			out.setContent("\t�ɹ�������Ϣ-����: "+inTextMsg.getContent().toString()+"\n");
			render(out);
		}
	}

	@Override
	protected void processInImageMsg(InImageMsg inImageMsg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void processInVoiceMsg(InVoiceMsg inVoiceMsg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void processInVideoMsg(InVideoMsg inVideoMsg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void processInShortVideoMsg(InShortVideoMsg inShortVideoMsg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void processInLocationMsg(InLocationMsg inLocationMsg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void processInLinkMsg(InLinkMsg inLinkMsg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void processInCustomEvent(InCustomEvent inCustomEvent) {
		// TODO Auto-generated method stub
		
	}
	//��ע����ȡ����ע ����
	@Override
	protected void processInFollowEvent(InFollowEvent inFollowEvent) {
		// TODO Auto-generated method stub
		
		if(inFollowEvent.EVENT_INFOLLOW_SUBSCRIBE.equals(inFollowEvent.getEvent())){
			
			
			OutTextMsg mg=new OutTextMsg(inFollowEvent);
			mg.setContent("��л���ע�ҵĹ��ںţ���\n �ظ��ؼ��ʣ����ţ����Կ������ˡ���");
			render(mg);
		}
		
		if(inFollowEvent.EVENT_INFOLLOW_UNSUBSCRIBE.equals(inFollowEvent.getEvent())){
			renderOutTextMsg("��ӭ������");
		}
	}
	//��ά���ע����Ϣ����
	@Override
	protected void processInQrCodeEvent(InQrCodeEvent inQrCodeEvent) {
		// TODO Auto-generated method stub
		OutTextMsg mg=new OutTextMsg(inQrCodeEvent);
		mg.setContent("��л���ע�ҵĹ��ںţ���\n �ظ��ؼ��ʣ����ţ����Կ������ˡ���");
		render(mg);
	}

	@Override
	protected void processInLocationEvent(InLocationEvent inLocationEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void processInMassEvent(InMassEvent inMassEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void processInMenuEvent(InMenuEvent inMenuEvent) {
		// TODO Auto-generated method stub
		String str=inMenuEvent.getEventKey();
		if(str.equalsIgnoreCase("���")){
			String str1="http://h.hiphotos.baidu.com/zhidao/pic/item/f9dcd100baa1cd113de632f3b812c8fcc2ce2d94.jpg";
			String str2="http://www.zzyybbs.com/";
			OutNewsMsg outnew=new OutNewsMsg(inMenuEvent);
			outnew.addNews("��","���㲻���������ۣ����������ˮ�����ܵ������ڿ����ĸ�ʪ�ȡ������Ӿ�ƣ�ͣ������������������ڿ�������������ʪ��.", str1, str2);
			render(outnew);
		}else if(str.equalsIgnoreCase("����")){
			OutTextMsg out=new OutTextMsg(inMenuEvent);
			out.setContent("����Իظ����飬���ŵȹؼ��ʡ�������������\n���Ƕ����԰����㣡");
			render(out);
		}
		
	}

	@Override
	protected void processInSpeechRecognitionResults(
			InSpeechRecognitionResults inSpeechRecognitionResults) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void processInTemplateMsgEvent(
			InTemplateMsgEvent inTemplateMsgEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void processInShakearoundUserShakeEvent(
			InShakearoundUserShakeEvent inShakearoundUserShakeEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void processInVerifySuccessEvent(
			InVerifySuccessEvent inVerifySuccessEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void processInVerifyFailEvent(InVerifyFailEvent inVerifyFailEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void processInPoiCheckNotifyEvent(
			InPoiCheckNotifyEvent inPoiCheckNotifyEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void processInWifiEvent(InWifiEvent inWifiEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void processInUserViewCardEvent(
			InUserViewCardEvent inUserViewCardEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void processInSubmitMemberCardEvent(
			InSubmitMemberCardEvent inSubmitMemberCardEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void processInUpdateMemberCardEvent(
			InUpdateMemberCardEvent inUpdateMemberCardEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void processInUserPayFromCardEvent(
			InUserPayFromCardEvent inUserPayFromCardEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void processInMerChantOrderEvent(
			InMerChantOrderEvent inMerChantOrderEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void processIsNotDefinedEvent(InNotDefinedEvent inNotDefinedEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void processIsNotDefinedMsg(InNotDefinedMsg inNotDefinedMsg) {
		// TODO Auto-generated method stub
		
	}
	
	public void index3(){
		renderText("Hello");
	}

}
