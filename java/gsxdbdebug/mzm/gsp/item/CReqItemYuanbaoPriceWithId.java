/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.item.main.PSynItemYuanbaoPriceWithId;
/*    */ 
/*    */ public class CReqItemYuanbaoPriceWithId
/*    */   extends __CReqItemYuanbaoPriceWithId__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584772;
/*    */   public int uid;
/*    */   public ArrayList<Integer> itemids;
/*    */   
/*    */   protected void process()
/*    */   {
/* 18 */     long roleId = Role.getRoleId(this);
/* 19 */     Role.addRoleProcedure(roleId, new PSynItemYuanbaoPriceWithId(roleId, this.itemids, this.uid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 28 */     return 12584772;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CReqItemYuanbaoPriceWithId()
/*    */   {
/* 35 */     this.itemids = new ArrayList();
/*    */   }
/*    */   
/*    */   public CReqItemYuanbaoPriceWithId(int _uid_, ArrayList<Integer> _itemids_) {
/* 39 */     this.uid = _uid_;
/* 40 */     this.itemids = _itemids_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.uid);
/* 49 */     _os_.compact_uint32(this.itemids.size());
/* 50 */     for (Integer _v_ : this.itemids) {
/* 51 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.uid = _os_.unmarshal_int();
/* 58 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 60 */       int _v_ = _os_.unmarshal_int();
/* 61 */       this.itemids.add(Integer.valueOf(_v_));
/*    */     }
/* 63 */     if (!_validator_()) {
/* 64 */       throw new VerifyError("validator failed");
/*    */     }
/* 66 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 70 */     if (_o1_ == this) return true;
/* 71 */     if ((_o1_ instanceof CReqItemYuanbaoPriceWithId)) {
/* 72 */       CReqItemYuanbaoPriceWithId _o_ = (CReqItemYuanbaoPriceWithId)_o1_;
/* 73 */       if (this.uid != _o_.uid) return false;
/* 74 */       if (!this.itemids.equals(_o_.itemids)) return false;
/* 75 */       return true;
/*    */     }
/* 77 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 81 */     int _h_ = 0;
/* 82 */     _h_ += this.uid;
/* 83 */     _h_ += this.itemids.hashCode();
/* 84 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 88 */     StringBuilder _sb_ = new StringBuilder();
/* 89 */     _sb_.append("(");
/* 90 */     _sb_.append(this.uid).append(",");
/* 91 */     _sb_.append(this.itemids).append(",");
/* 92 */     _sb_.append(")");
/* 93 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CReqItemYuanbaoPriceWithId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */