/*    */ package mzm.gsp.task;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashSet;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.task.surprise.PCAccepteSurpriseItemReq;
/*    */ 
/*    */ public class CAccepteSurpriseItemReq
/*    */   extends __CAccepteSurpriseItemReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12592154;
/*    */   public int serverid;
/*    */   public ArrayList<Long> uuids;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleId, new PCAccepteSurpriseItemReq(roleId, this.serverid, new HashSet(this.uuids)));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12592154;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CAccepteSurpriseItemReq()
/*    */   {
/* 38 */     this.uuids = new ArrayList();
/*    */   }
/*    */   
/*    */   public CAccepteSurpriseItemReq(int _serverid_, ArrayList<Long> _uuids_) {
/* 42 */     this.serverid = _serverid_;
/* 43 */     this.uuids = _uuids_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.serverid);
/* 52 */     _os_.compact_uint32(this.uuids.size());
/* 53 */     for (Long _v_ : this.uuids) {
/* 54 */       _os_.marshal(_v_.longValue());
/*    */     }
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 60 */     this.serverid = _os_.unmarshal_int();
/* 61 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 63 */       long _v_ = _os_.unmarshal_long();
/* 64 */       this.uuids.add(Long.valueOf(_v_));
/*    */     }
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof CAccepteSurpriseItemReq)) {
/* 75 */       CAccepteSurpriseItemReq _o_ = (CAccepteSurpriseItemReq)_o1_;
/* 76 */       if (this.serverid != _o_.serverid) return false;
/* 77 */       if (!this.uuids.equals(_o_.uuids)) return false;
/* 78 */       return true;
/*    */     }
/* 80 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 84 */     int _h_ = 0;
/* 85 */     _h_ += this.serverid;
/* 86 */     _h_ += this.uuids.hashCode();
/* 87 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 91 */     StringBuilder _sb_ = new StringBuilder();
/* 92 */     _sb_.append("(");
/* 93 */     _sb_.append(this.serverid).append(",");
/* 94 */     _sb_.append(this.uuids).append(",");
/* 95 */     _sb_.append(")");
/* 96 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\CAccepteSurpriseItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */