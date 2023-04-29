/*    */ package mzm.gsp.baitan;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.LinkedList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.baitan.main.PRecommandPriceReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CRecommendPriceChangeReq
/*    */   extends __CRecommendPriceChangeReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584994;
/*    */   public LinkedList<Integer> itemidlist;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId < 0L) {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PRecommandPriceReq(roleId, this.itemidlist));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 33 */     return 12584994;
/*    */   }
/*    */   
/*    */ 
/*    */   public CRecommendPriceChangeReq()
/*    */   {
/* 39 */     this.itemidlist = new LinkedList();
/*    */   }
/*    */   
/*    */   public CRecommendPriceChangeReq(LinkedList<Integer> _itemidlist_) {
/* 43 */     this.itemidlist = _itemidlist_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.compact_uint32(this.itemidlist.size());
/* 52 */     for (Integer _v_ : this.itemidlist) {
/* 53 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 61 */       int _v_ = _os_.unmarshal_int();
/* 62 */       this.itemidlist.add(Integer.valueOf(_v_));
/*    */     }
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof CRecommendPriceChangeReq)) {
/* 73 */       CRecommendPriceChangeReq _o_ = (CRecommendPriceChangeReq)_o1_;
/* 74 */       if (!this.itemidlist.equals(_o_.itemidlist)) return false;
/* 75 */       return true;
/*    */     }
/* 77 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 81 */     int _h_ = 0;
/* 82 */     _h_ += this.itemidlist.hashCode();
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.itemidlist).append(",");
/* 90 */     _sb_.append(")");
/* 91 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\CRecommendPriceChangeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */