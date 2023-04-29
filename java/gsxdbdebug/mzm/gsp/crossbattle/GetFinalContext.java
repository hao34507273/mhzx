/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class GetFinalContext
/*    */   implements Marshal
/*    */ {
/*    */   public static final int OPER_CHECK_PANEL_REQ = 0;
/*    */   public static final int OPER_GET_SPECIAL_FIGHT_ZONE_REQ = 1;
/*    */   public static final int OPER_CREATE_PREPARE_WORLD_REQ = 2;
/*    */   public static final int OPER_GET_STAGE_BET_INFO_REQ = 3;
/*    */   public static final int OPER_GET_FIGHT_ZONE_INFO_REQ = 4;
/*    */   public int oper_type;
/*    */   public Octets content;
/*    */   
/*    */   public GetFinalContext()
/*    */   {
/* 21 */     this.content = new Octets();
/*    */   }
/*    */   
/*    */   public GetFinalContext(int _oper_type_, Octets _content_) {
/* 25 */     this.oper_type = _oper_type_;
/* 26 */     this.content = _content_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 34 */     _os_.marshal(this.oper_type);
/* 35 */     _os_.marshal(this.content);
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 40 */     this.oper_type = _os_.unmarshal_int();
/* 41 */     this.content = _os_.unmarshal_Octets();
/* 42 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 46 */     if (_o1_ == this) return true;
/* 47 */     if ((_o1_ instanceof GetFinalContext)) {
/* 48 */       GetFinalContext _o_ = (GetFinalContext)_o1_;
/* 49 */       if (this.oper_type != _o_.oper_type) return false;
/* 50 */       if (!this.content.equals(_o_.content)) return false;
/* 51 */       return true;
/*    */     }
/* 53 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 57 */     int _h_ = 0;
/* 58 */     _h_ += this.oper_type;
/* 59 */     _h_ += this.content.hashCode();
/* 60 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 64 */     StringBuilder _sb_ = new StringBuilder();
/* 65 */     _sb_.append("(");
/* 66 */     _sb_.append(this.oper_type).append(",");
/* 67 */     _sb_.append("B").append(this.content.size()).append(",");
/* 68 */     _sb_.append(")");
/* 69 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\GetFinalContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */