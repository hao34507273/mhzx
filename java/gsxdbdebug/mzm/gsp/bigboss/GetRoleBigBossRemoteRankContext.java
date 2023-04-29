/*    */ package mzm.gsp.bigboss;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class GetRoleBigBossRemoteRankContext
/*    */   implements Marshal
/*    */ {
/*    */   public static final int OPER_TYPE_CLIENT_REQ = 0;
/*    */   public byte oper_type;
/*    */   public byte count;
/*    */   public Octets extra_info;
/*    */   
/*    */   public GetRoleBigBossRemoteRankContext()
/*    */   {
/* 18 */     this.extra_info = new Octets();
/*    */   }
/*    */   
/*    */   public GetRoleBigBossRemoteRankContext(byte _oper_type_, byte _count_, Octets _extra_info_) {
/* 22 */     this.oper_type = _oper_type_;
/* 23 */     this.count = _count_;
/* 24 */     this.extra_info = _extra_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 32 */     _os_.marshal(this.oper_type);
/* 33 */     _os_.marshal(this.count);
/* 34 */     _os_.marshal(this.extra_info);
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 39 */     this.oper_type = _os_.unmarshal_byte();
/* 40 */     this.count = _os_.unmarshal_byte();
/* 41 */     this.extra_info = _os_.unmarshal_Octets();
/* 42 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 46 */     if (_o1_ == this) return true;
/* 47 */     if ((_o1_ instanceof GetRoleBigBossRemoteRankContext)) {
/* 48 */       GetRoleBigBossRemoteRankContext _o_ = (GetRoleBigBossRemoteRankContext)_o1_;
/* 49 */       if (this.oper_type != _o_.oper_type) return false;
/* 50 */       if (this.count != _o_.count) return false;
/* 51 */       if (!this.extra_info.equals(_o_.extra_info)) return false;
/* 52 */       return true;
/*    */     }
/* 54 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 58 */     int _h_ = 0;
/* 59 */     _h_ += this.oper_type;
/* 60 */     _h_ += this.count;
/* 61 */     _h_ += this.extra_info.hashCode();
/* 62 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 66 */     StringBuilder _sb_ = new StringBuilder();
/* 67 */     _sb_.append("(");
/* 68 */     _sb_.append(this.oper_type).append(",");
/* 69 */     _sb_.append(this.count).append(",");
/* 70 */     _sb_.append("B").append(this.extra_info.size()).append(",");
/* 71 */     _sb_.append(")");
/* 72 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\GetRoleBigBossRemoteRankContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */