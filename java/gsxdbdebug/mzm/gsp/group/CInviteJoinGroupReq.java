/*    */ package mzm.gsp.group;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.group.main.PInviteJoinGroupReq;
/*    */ 
/*    */ 
/*    */ public class CInviteJoinGroupReq
/*    */   extends __CInviteJoinGroupReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12605187;
/*    */   public long groupid;
/*    */   public ArrayList<Long> invitees;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     if (roleid < 0L)
/* 22 */       return;
/* 23 */     for (Iterator i$ = this.invitees.iterator(); i$.hasNext();) { long invitee = ((Long)i$.next()).longValue();
/* 24 */       Role.addRoleProcedure(roleid, new PInviteJoinGroupReq(roleid, invitee, this.groupid));
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12605187;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CInviteJoinGroupReq()
/*    */   {
/* 39 */     this.invitees = new ArrayList();
/*    */   }
/*    */   
/*    */   public CInviteJoinGroupReq(long _groupid_, ArrayList<Long> _invitees_) {
/* 43 */     this.groupid = _groupid_;
/* 44 */     this.invitees = _invitees_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 48 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 52 */     _os_.marshal(this.groupid);
/* 53 */     _os_.compact_uint32(this.invitees.size());
/* 54 */     for (Long _v_ : this.invitees) {
/* 55 */       _os_.marshal(_v_.longValue());
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 61 */     this.groupid = _os_.unmarshal_long();
/* 62 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 64 */       long _v_ = _os_.unmarshal_long();
/* 65 */       this.invitees.add(Long.valueOf(_v_));
/*    */     }
/* 67 */     if (!_validator_()) {
/* 68 */       throw new VerifyError("validator failed");
/*    */     }
/* 70 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 74 */     if (_o1_ == this) return true;
/* 75 */     if ((_o1_ instanceof CInviteJoinGroupReq)) {
/* 76 */       CInviteJoinGroupReq _o_ = (CInviteJoinGroupReq)_o1_;
/* 77 */       if (this.groupid != _o_.groupid) return false;
/* 78 */       if (!this.invitees.equals(_o_.invitees)) return false;
/* 79 */       return true;
/*    */     }
/* 81 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 85 */     int _h_ = 0;
/* 86 */     _h_ += (int)this.groupid;
/* 87 */     _h_ += this.invitees.hashCode();
/* 88 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 92 */     StringBuilder _sb_ = new StringBuilder();
/* 93 */     _sb_.append("(");
/* 94 */     _sb_.append(this.groupid).append(",");
/* 95 */     _sb_.append(this.invitees).append(",");
/* 96 */     _sb_.append(")");
/* 97 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\CInviteJoinGroupReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */