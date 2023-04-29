/*    */ package mzm.gsp.watchmoon;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.watchmoon.main.PGetWatchMoonCount;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetWatchCountReq
/*    */   extends __CGetWatchCountReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12600834;
/*    */   public ArrayList<Long> roleids;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleId, new PGetWatchMoonCount(this.roleids, roleId));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 30 */     return 12600834;
/*    */   }
/*    */   
/*    */ 
/*    */   public CGetWatchCountReq()
/*    */   {
/* 36 */     this.roleids = new ArrayList();
/*    */   }
/*    */   
/*    */   public CGetWatchCountReq(ArrayList<Long> _roleids_) {
/* 40 */     this.roleids = _roleids_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.compact_uint32(this.roleids.size());
/* 49 */     for (Long _v_ : this.roleids) {
/* 50 */       _os_.marshal(_v_.longValue());
/*    */     }
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 58 */       long _v_ = _os_.unmarshal_long();
/* 59 */       this.roleids.add(Long.valueOf(_v_));
/*    */     }
/* 61 */     if (!_validator_()) {
/* 62 */       throw new VerifyError("validator failed");
/*    */     }
/* 64 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 68 */     if (_o1_ == this) return true;
/* 69 */     if ((_o1_ instanceof CGetWatchCountReq)) {
/* 70 */       CGetWatchCountReq _o_ = (CGetWatchCountReq)_o1_;
/* 71 */       if (!this.roleids.equals(_o_.roleids)) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.roleids.hashCode();
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.roleids).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\watchmoon\CGetWatchCountReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */