/*    */ package mzm.gsp.instance.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class SingleInstanceData implements Marshal
/*    */ {
/*    */   public int instanceid;
/*    */   public int monsterid;
/*    */   public int awardid;
/*    */   public int in_mapid;
/*    */   public int triggerid;
/*    */   public int awardPoolLibid;
/*    */   public int sao_dang_item_num;
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 19 */     this.instanceid = Integer.valueOf(rootElement.attributeValue("instanceid")).intValue();
/* 20 */     this.monsterid = Integer.valueOf(rootElement.attributeValue("monsterid")).intValue();
/* 21 */     this.awardid = Integer.valueOf(rootElement.attributeValue("awardid")).intValue();
/* 22 */     this.in_mapid = Integer.valueOf(rootElement.attributeValue("in_mapid")).intValue();
/* 23 */     this.triggerid = Integer.valueOf(rootElement.attributeValue("triggerid")).intValue();
/* 24 */     this.awardPoolLibid = Integer.valueOf(rootElement.attributeValue("awardPoolLibid")).intValue();
/* 25 */     this.sao_dang_item_num = Integer.valueOf(rootElement.attributeValue("sao_dang_item_num")).intValue();
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 30 */     _os_.marshal(this.instanceid);
/* 31 */     _os_.marshal(this.monsterid);
/* 32 */     _os_.marshal(this.awardid);
/* 33 */     _os_.marshal(this.in_mapid);
/* 34 */     _os_.marshal(this.triggerid);
/* 35 */     _os_.marshal(this.awardPoolLibid);
/* 36 */     _os_.marshal(this.sao_dang_item_num);
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 42 */     this.instanceid = _os_.unmarshal_int();
/* 43 */     this.monsterid = _os_.unmarshal_int();
/* 44 */     this.awardid = _os_.unmarshal_int();
/* 45 */     this.in_mapid = _os_.unmarshal_int();
/* 46 */     this.triggerid = _os_.unmarshal_int();
/* 47 */     this.awardPoolLibid = _os_.unmarshal_int();
/* 48 */     this.sao_dang_item_num = _os_.unmarshal_int();
/* 49 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\confbean\SingleInstanceData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */