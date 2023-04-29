/*    */ package mzm.gsp.crossbattle.confbean;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ import org.dom4j.Element;
/*    */ 
/*    */ public class RankAwardBuffList implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int buff_last_day;
/* 10 */   public ArrayList<RankAwardBuffBean> buff_list = new ArrayList();
/*    */   
/*    */   public void loadFromXml(Element rootElement)
/*    */   {
/* 14 */     this.buff_last_day = Integer.valueOf(rootElement.attributeValue("buff_last_day")).intValue();
/*    */     
/* 16 */     Element collectionElement = util.XmlHelper.getVariableElement(rootElement, "buff_list");
/* 17 */     if (collectionElement == null)
/*    */     {
/* 19 */       throw new RuntimeException("collection type element does not find");
/*    */     }
/*    */     
/* 22 */     java.util.List<?> _nodeList = collectionElement.elements();
/* 23 */     int _len = _nodeList.size();
/* 24 */     for (int i = 0; i < _len; i++)
/*    */     {
/* 26 */       Element elem = (Element)_nodeList.get(i);
/* 27 */       if (elem.getName().equalsIgnoreCase("mzm.gsp.crossbattle.confbean.RankAwardBuffBean"))
/*    */       {
/*    */         RankAwardBuffBean _v_;
/*    */         
/*    */ 
/*    */         try
/*    */         {
/* 34 */           _v_ = new RankAwardBuffBean();
/* 35 */           _v_.loadFromXml(elem);
/*    */         }
/*    */         catch (Exception e)
/*    */         {
/*    */           continue;
/*    */         }
/*    */         
/* 42 */         this.buff_list.add(_v_);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_)
/*    */   {
/* 49 */     _os_.marshal(this.buff_last_day);
/* 50 */     _os_.compact_uint32(this.buff_list.size());
/* 51 */     for (RankAwardBuffBean _v_ : this.buff_list)
/*    */     {
/* 53 */       _os_.marshal(_v_);
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException
/*    */   {
/* 60 */     this.buff_last_day = _os_.unmarshal_int();
/* 61 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/*    */ 
/* 64 */       RankAwardBuffBean _v_ = new RankAwardBuffBean();
/* 65 */       _v_.unmarshal(_os_);
/* 66 */       this.buff_list.add(_v_);
/*    */     }
/* 68 */     return _os_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\confbean\RankAwardBuffList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */