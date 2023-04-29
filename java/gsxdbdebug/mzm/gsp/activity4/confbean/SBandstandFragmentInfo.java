/*    */ package mzm.gsp.activity4.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SBandstandFragmentInfo implements Marshal
/*    */ {
/*    */   public int index;
/*    */   public int fragmentType;
/*    */   public int musicTime;
/*    */   public int answerNum;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 16 */     this.index = Integer.valueOf(rootElement.attributeValue("index")).intValue();
/* 17 */     this.fragmentType = Integer.valueOf(rootElement.attributeValue("fragmentType")).intValue();
/* 18 */     this.musicTime = Integer.valueOf(rootElement.attributeValue("musicTime")).intValue();
/* 19 */     this.answerNum = Integer.valueOf(rootElement.attributeValue("answerNum")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 24 */     _os_.marshal(this.index);
/* 25 */     _os_.marshal(this.fragmentType);
/* 26 */     _os_.marshal(this.musicTime);
/* 27 */     _os_.marshal(this.answerNum);
/* 28 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 33 */     this.index = _os_.unmarshal_int();
/* 34 */     this.fragmentType = _os_.unmarshal_int();
/* 35 */     this.musicTime = _os_.unmarshal_int();
/* 36 */     this.answerNum = _os_.unmarshal_int();
/* 37 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity4\confbean\SBandstandFragmentInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */