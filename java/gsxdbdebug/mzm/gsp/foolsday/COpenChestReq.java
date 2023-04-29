/*    */ package mzm.gsp.foolsday;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.foolsday.main.PCOpenChest;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class COpenChestReq
/*    */   extends __COpenChestReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12612866;
/*    */   public int grid;
/*    */   public long makerid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     if (roleid < 0L)
/* 22 */       return;
/* 23 */     Role.addRoleProcedure(roleid, new PCOpenChest(roleid, this.grid, this.makerid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12612866;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public COpenChestReq() {}
/*    */   
/*    */ 
/*    */   public COpenChestReq(int _grid_, long _makerid_)
/*    */   {
/* 41 */     this.grid = _grid_;
/* 42 */     this.makerid = _makerid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.grid);
/* 51 */     _os_.marshal(this.makerid);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.grid = _os_.unmarshal_int();
/* 57 */     this.makerid = _os_.unmarshal_long();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof COpenChestReq)) {
/* 67 */       COpenChestReq _o_ = (COpenChestReq)_o1_;
/* 68 */       if (this.grid != _o_.grid) return false;
/* 69 */       if (this.makerid != _o_.makerid) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.grid;
/* 78 */     _h_ += (int)this.makerid;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.grid).append(",");
/* 86 */     _sb_.append(this.makerid).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(COpenChestReq _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = this.grid - _o_.grid;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = Long.signum(this.makerid - _o_.makerid);
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\foolsday\COpenChestReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */