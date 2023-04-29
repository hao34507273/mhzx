/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class GetKnockOutContext
/*    */   implements Marshal
/*    */ {
/*    */   public static final int OPER_REFRESH_KNOCK_OUT_DATA = -1;
/*    */   public static final int OPER_CHECK_PANEL_REQ = 0;
/*    */   public static final int OPER_GET_SPECIAL_FIGHT_ZONE_REQ = 1;
/*    */   public static final int OPER_CREATE_PREPARE_WORLD_REQ = 2;
/*    */   public static final int OPER_GET_STAGE_BET_INFO_REQ = 3;
/*    */   public static final int OPER_GET_FIGHT_ZONE_INFO_REQ = 4;
/*    */   public static final int OPER_BET_IN_KNOCKOUT = 5;
/*    */   public static final int OPER_SETTLE_KNOCKOUT_STAGE_BET = 6;
/*    */   public static final int OPER_SETTLE_ROLE_KNOCKOUT_STAGE_BET = 7;
/*    */   public static final int OPER_REPORT_FIGHT_RESULT = 8;
/*    */   public static final int OPER_NOTIFY_FIGHT_RESULT = 9;
/*    */   public static final int OPER_KNOCK_OUT_AWARD = 10;
/*    */   public static final int OPER_HISTORY_GET_FIGHT = 11;
/*    */   public static final int OPER_HISTORY_TOP_THREE_CORPS_INFO = 12;
/*    */   public static final int OPER_CHAMPION_CORPS_INFO = 13;
/*    */   public static final int OPER_FINAL_SERVER_AWARD = 14;
/*    */   public int oper_type;
/*    */   public Octets content;
/*    */   
/*    */   public GetKnockOutContext()
/*    */   {
/* 32 */     this.content = new Octets();
/*    */   }
/*    */   
/*    */   public GetKnockOutContext(int _oper_type_, Octets _content_) {
/* 36 */     this.oper_type = _oper_type_;
/* 37 */     this.content = _content_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.marshal(this.oper_type);
/* 46 */     _os_.marshal(this.content);
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     this.oper_type = _os_.unmarshal_int();
/* 52 */     this.content = _os_.unmarshal_Octets();
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 57 */     if (_o1_ == this) return true;
/* 58 */     if ((_o1_ instanceof GetKnockOutContext)) {
/* 59 */       GetKnockOutContext _o_ = (GetKnockOutContext)_o1_;
/* 60 */       if (this.oper_type != _o_.oper_type) return false;
/* 61 */       if (!this.content.equals(_o_.content)) return false;
/* 62 */       return true;
/*    */     }
/* 64 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 68 */     int _h_ = 0;
/* 69 */     _h_ += this.oper_type;
/* 70 */     _h_ += this.content.hashCode();
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.oper_type).append(",");
/* 78 */     _sb_.append("B").append(this.content.size()).append(",");
/* 79 */     _sb_.append(")");
/* 80 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\GetKnockOutContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */