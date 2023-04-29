/*    */ package mzm.gsp.bigboss;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class GetBigBossRemoteRankContext
/*    */   implements Marshal
/*    */ {
/*    */   public static final int OPER_TYPE_CLIENT_REQ = 0;
/*    */   public static final int OPER_TYPE_RANK_AWARD = 1;
/*    */   public byte oper_type;
/*    */   public byte count;
/*    */   public Octets extra_info;
/*    */   
/*    */   public GetBigBossRemoteRankContext()
/*    */   {
/* 19 */     this.extra_info = new Octets();
/*    */   }
/*    */   
/*    */   public GetBigBossRemoteRankContext(byte _oper_type_, byte _count_, Octets _extra_info_) {
/* 23 */     this.oper_type = _oper_type_;
/* 24 */     this.count = _count_;
/* 25 */     this.extra_info = _extra_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 33 */     _os_.marshal(this.oper_type);
/* 34 */     _os_.marshal(this.count);
/* 35 */     _os_.marshal(this.extra_info);
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 40 */     this.oper_type = _os_.unmarshal_byte();
/* 41 */     this.count = _os_.unmarshal_byte();
/* 42 */     this.extra_info = _os_.unmarshal_Octets();
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 47 */     if (_o1_ == this) return true;
/* 48 */     if ((_o1_ instanceof GetBigBossRemoteRankContext)) {
/* 49 */       GetBigBossRemoteRankContext _o_ = (GetBigBossRemoteRankContext)_o1_;
/* 50 */       if (this.oper_type != _o_.oper_type) return false;
/* 51 */       if (this.count != _o_.count) return false;
/* 52 */       if (!this.extra_info.equals(_o_.extra_info)) return false;
/* 53 */       return true;
/*    */     }
/* 55 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 59 */     int _h_ = 0;
/* 60 */     _h_ += this.oper_type;
/* 61 */     _h_ += this.count;
/* 62 */     _h_ += this.extra_info.hashCode();
/* 63 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 67 */     StringBuilder _sb_ = new StringBuilder();
/* 68 */     _sb_.append("(");
/* 69 */     _sb_.append(this.oper_type).append(",");
/* 70 */     _sb_.append(this.count).append(",");
/* 71 */     _sb_.append("B").append(this.extra_info.size()).append(",");
/* 72 */     _sb_.append(")");
/* 73 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\GetBigBossRemoteRankContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */