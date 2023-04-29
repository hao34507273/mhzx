/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class GetFightStageCorpsIdList
/*    */   implements Marshal
/*    */ {
/*    */   public static final int OPER_NOTIFY_KNOCK_OUT_CORPS_ID = 1;
/*    */   public static final int OPER_AWARD = 2;
/*    */   public int oper_type;
/*    */   public Octets content;
/*    */   
/*    */   public GetFightStageCorpsIdList()
/*    */   {
/* 18 */     this.content = new Octets();
/*    */   }
/*    */   
/*    */   public GetFightStageCorpsIdList(int _oper_type_, Octets _content_) {
/* 22 */     this.oper_type = _oper_type_;
/* 23 */     this.content = _content_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.marshal(this.oper_type);
/* 32 */     _os_.marshal(this.content);
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 37 */     this.oper_type = _os_.unmarshal_int();
/* 38 */     this.content = _os_.unmarshal_Octets();
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 43 */     if (_o1_ == this) return true;
/* 44 */     if ((_o1_ instanceof GetFightStageCorpsIdList)) {
/* 45 */       GetFightStageCorpsIdList _o_ = (GetFightStageCorpsIdList)_o1_;
/* 46 */       if (this.oper_type != _o_.oper_type) return false;
/* 47 */       if (!this.content.equals(_o_.content)) return false;
/* 48 */       return true;
/*    */     }
/* 50 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 54 */     int _h_ = 0;
/* 55 */     _h_ += this.oper_type;
/* 56 */     _h_ += this.content.hashCode();
/* 57 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 61 */     StringBuilder _sb_ = new StringBuilder();
/* 62 */     _sb_.append("(");
/* 63 */     _sb_.append(this.oper_type).append(",");
/* 64 */     _sb_.append("B").append(this.content.size()).append(",");
/* 65 */     _sb_.append(")");
/* 66 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\GetFightStageCorpsIdList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */