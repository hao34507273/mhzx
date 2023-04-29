/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.item.main.PCOnkeySellItemReq;
/*    */ 
/*    */ public class COneKeySellItemReq
/*    */   extends __COneKeySellItemReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584813;
/*    */   public int bagid;
/*    */   public ArrayList<Uuid2num> uuid2nums;
/*    */   
/*    */   protected void process()
/*    */   {
/* 18 */     long roleid = Role.getRoleId(this);
/* 19 */     Role.addRoleProcedure(roleid, new PCOnkeySellItemReq(roleid, this.bagid, this.uuid2nums));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 28 */     return 12584813;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public COneKeySellItemReq()
/*    */   {
/* 35 */     this.uuid2nums = new ArrayList();
/*    */   }
/*    */   
/*    */   public COneKeySellItemReq(int _bagid_, ArrayList<Uuid2num> _uuid2nums_) {
/* 39 */     this.bagid = _bagid_;
/* 40 */     this.uuid2nums = _uuid2nums_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     for (Uuid2num _v_ : this.uuid2nums)
/* 45 */       if (!_v_._validator_()) return false;
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.bagid);
/* 51 */     _os_.compact_uint32(this.uuid2nums.size());
/* 52 */     for (Uuid2num _v_ : this.uuid2nums) {
/* 53 */       _os_.marshal(_v_);
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.bagid = _os_.unmarshal_int();
/* 60 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 61 */       Uuid2num _v_ = new Uuid2num();
/* 62 */       _v_.unmarshal(_os_);
/* 63 */       this.uuid2nums.add(_v_);
/*    */     }
/* 65 */     if (!_validator_()) {
/* 66 */       throw new VerifyError("validator failed");
/*    */     }
/* 68 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 72 */     if (_o1_ == this) return true;
/* 73 */     if ((_o1_ instanceof COneKeySellItemReq)) {
/* 74 */       COneKeySellItemReq _o_ = (COneKeySellItemReq)_o1_;
/* 75 */       if (this.bagid != _o_.bagid) return false;
/* 76 */       if (!this.uuid2nums.equals(_o_.uuid2nums)) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += this.bagid;
/* 85 */     _h_ += this.uuid2nums.hashCode();
/* 86 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 90 */     StringBuilder _sb_ = new StringBuilder();
/* 91 */     _sb_.append("(");
/* 92 */     _sb_.append(this.bagid).append(",");
/* 93 */     _sb_.append(this.uuid2nums).append(",");
/* 94 */     _sb_.append(")");
/* 95 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\COneKeySellItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */