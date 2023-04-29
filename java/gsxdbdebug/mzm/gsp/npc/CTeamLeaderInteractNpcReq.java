/*    */ package mzm.gsp.npc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.npc.main.PCTeamLeaderInteractNpcReq;
/*    */ 
/*    */ public class CTeamLeaderInteractNpcReq
/*    */   extends __CTeamLeaderInteractNpcReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12586753;
/*    */   public int npcid;
/*    */   public ArrayList<Integer> args;
/*    */   
/*    */   protected void process()
/*    */   {
/* 18 */     long roleId = Role.getRoleId(this);
/* 19 */     Role.addRoleProcedure(roleId, new PCTeamLeaderInteractNpcReq(roleId, this));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 27 */     return 12586753;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CTeamLeaderInteractNpcReq()
/*    */   {
/* 34 */     this.args = new ArrayList();
/*    */   }
/*    */   
/*    */   public CTeamLeaderInteractNpcReq(int _npcid_, ArrayList<Integer> _args_) {
/* 38 */     this.npcid = _npcid_;
/* 39 */     this.args = _args_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.npcid);
/* 48 */     _os_.compact_uint32(this.args.size());
/* 49 */     for (Integer _v_ : this.args) {
/* 50 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.npcid = _os_.unmarshal_int();
/* 57 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 59 */       int _v_ = _os_.unmarshal_int();
/* 60 */       this.args.add(Integer.valueOf(_v_));
/*    */     }
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof CTeamLeaderInteractNpcReq)) {
/* 71 */       CTeamLeaderInteractNpcReq _o_ = (CTeamLeaderInteractNpcReq)_o1_;
/* 72 */       if (this.npcid != _o_.npcid) return false;
/* 73 */       if (!this.args.equals(_o_.args)) return false;
/* 74 */       return true;
/*    */     }
/* 76 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 80 */     int _h_ = 0;
/* 81 */     _h_ += this.npcid;
/* 82 */     _h_ += this.args.hashCode();
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.npcid).append(",");
/* 90 */     _sb_.append(this.args).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npc\CTeamLeaderInteractNpcReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */