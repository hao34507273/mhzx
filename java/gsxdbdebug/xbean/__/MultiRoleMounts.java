/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class MultiRoleMounts extends XBean implements xbean.MultiRoleMounts
/*     */ {
/*     */   private int mounts_cfg_id;
/*     */   private ArrayList<Long> role_ids;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.mounts_cfg_id = 0;
/*  21 */     this.role_ids.clear();
/*     */   }
/*     */   
/*     */   MultiRoleMounts(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.role_ids = new ArrayList();
/*     */   }
/*     */   
/*     */   public MultiRoleMounts()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public MultiRoleMounts(MultiRoleMounts _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   MultiRoleMounts(xbean.MultiRoleMounts _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof MultiRoleMounts)) { assign((MultiRoleMounts)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(MultiRoleMounts _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.mounts_cfg_id = _o_.mounts_cfg_id;
/*  53 */     this.role_ids = new ArrayList();
/*  54 */     this.role_ids.addAll(_o_.role_ids);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  59 */     this.mounts_cfg_id = _o_.mounts_cfg_id;
/*  60 */     this.role_ids = new ArrayList();
/*  61 */     this.role_ids.addAll(_o_.role_ids);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  67 */     _xdb_verify_unsafe_();
/*  68 */     _os_.marshal(this.mounts_cfg_id);
/*  69 */     _os_.compact_uint32(this.role_ids.size());
/*  70 */     for (Long _v_ : this.role_ids)
/*     */     {
/*  72 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  80 */     _xdb_verify_unsafe_();
/*  81 */     this.mounts_cfg_id = _os_.unmarshal_int();
/*  82 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  84 */       long _v_ = 0L;
/*  85 */       _v_ = _os_.unmarshal_long();
/*  86 */       this.role_ids.add(Long.valueOf(_v_));
/*     */     }
/*  88 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  94 */     _xdb_verify_unsafe_();
/*  95 */     int _size_ = 0;
/*  96 */     _size_ += CodedOutputStream.computeInt32Size(1, this.mounts_cfg_id);
/*  97 */     for (Long _v_ : this.role_ids)
/*     */     {
/*  99 */       _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*     */     }
/* 101 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 107 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 110 */       _output_.writeInt32(1, this.mounts_cfg_id);
/* 111 */       for (Long _v_ : this.role_ids)
/*     */       {
/* 113 */         _output_.writeInt64(2, _v_.longValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 118 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 120 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 126 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 129 */       boolean done = false;
/* 130 */       while (!done)
/*     */       {
/* 132 */         int tag = _input_.readTag();
/* 133 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 137 */           done = true;
/* 138 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 142 */           this.mounts_cfg_id = _input_.readInt32();
/* 143 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 147 */           long _v_ = 0L;
/* 148 */           _v_ = _input_.readInt64();
/* 149 */           this.role_ids.add(Long.valueOf(_v_));
/* 150 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 154 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 156 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 165 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 169 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 171 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MultiRoleMounts copy()
/*     */   {
/* 177 */     _xdb_verify_unsafe_();
/* 178 */     return new MultiRoleMounts(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MultiRoleMounts toData()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MultiRoleMounts toBean()
/*     */   {
/* 190 */     _xdb_verify_unsafe_();
/* 191 */     return new MultiRoleMounts(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MultiRoleMounts toDataIf()
/*     */   {
/* 197 */     _xdb_verify_unsafe_();
/* 198 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MultiRoleMounts toBeanIf()
/*     */   {
/* 203 */     _xdb_verify_unsafe_();
/* 204 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 210 */     _xdb_verify_unsafe_();
/* 211 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getMounts_cfg_id()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return this.mounts_cfg_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Long> getRole_ids()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return xdb.Logs.logList(new LogKey(this, "role_ids"), this.role_ids);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Long> getRole_idsAsData()
/*     */   {
/* 233 */     _xdb_verify_unsafe_();
/*     */     
/* 235 */     MultiRoleMounts _o_ = this;
/* 236 */     List<Long> role_ids = new ArrayList();
/* 237 */     role_ids.addAll(_o_.role_ids);
/* 238 */     return role_ids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMounts_cfg_id(int _v_)
/*     */   {
/* 245 */     _xdb_verify_unsafe_();
/* 246 */     xdb.Logs.logIf(new LogKey(this, "mounts_cfg_id")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 250 */         new xdb.logs.LogInt(this, MultiRoleMounts.this.mounts_cfg_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 254 */             MultiRoleMounts.this.mounts_cfg_id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 258 */     });
/* 259 */     this.mounts_cfg_id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 265 */     _xdb_verify_unsafe_();
/* 266 */     MultiRoleMounts _o_ = null;
/* 267 */     if ((_o1_ instanceof MultiRoleMounts)) { _o_ = (MultiRoleMounts)_o1_;
/* 268 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 269 */       return false;
/* 270 */     if (this.mounts_cfg_id != _o_.mounts_cfg_id) return false;
/* 271 */     if (!this.role_ids.equals(_o_.role_ids)) return false;
/* 272 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     int _h_ = 0;
/* 280 */     _h_ += this.mounts_cfg_id;
/* 281 */     _h_ += this.role_ids.hashCode();
/* 282 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     StringBuilder _sb_ = new StringBuilder();
/* 290 */     _sb_.append("(");
/* 291 */     _sb_.append(this.mounts_cfg_id);
/* 292 */     _sb_.append(",");
/* 293 */     _sb_.append(this.role_ids);
/* 294 */     _sb_.append(")");
/* 295 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 301 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 302 */     lb.add(new xdb.logs.ListenableChanged().setVarName("mounts_cfg_id"));
/* 303 */     lb.add(new xdb.logs.ListenableChanged().setVarName("role_ids"));
/* 304 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.MultiRoleMounts {
/*     */     private Const() {}
/*     */     
/*     */     MultiRoleMounts nThis() {
/* 311 */       return MultiRoleMounts.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 317 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MultiRoleMounts copy()
/*     */     {
/* 323 */       return MultiRoleMounts.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MultiRoleMounts toData()
/*     */     {
/* 329 */       return MultiRoleMounts.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.MultiRoleMounts toBean()
/*     */     {
/* 334 */       return MultiRoleMounts.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MultiRoleMounts toDataIf()
/*     */     {
/* 340 */       return MultiRoleMounts.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.MultiRoleMounts toBeanIf()
/*     */     {
/* 345 */       return MultiRoleMounts.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getMounts_cfg_id()
/*     */     {
/* 352 */       MultiRoleMounts.this._xdb_verify_unsafe_();
/* 353 */       return MultiRoleMounts.this.mounts_cfg_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getRole_ids()
/*     */     {
/* 360 */       MultiRoleMounts.this._xdb_verify_unsafe_();
/* 361 */       return xdb.Consts.constList(MultiRoleMounts.this.role_ids);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Long> getRole_idsAsData()
/*     */     {
/* 367 */       MultiRoleMounts.this._xdb_verify_unsafe_();
/*     */       
/* 369 */       MultiRoleMounts _o_ = MultiRoleMounts.this;
/* 370 */       List<Long> role_ids = new ArrayList();
/* 371 */       role_ids.addAll(_o_.role_ids);
/* 372 */       return role_ids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMounts_cfg_id(int _v_)
/*     */     {
/* 379 */       MultiRoleMounts.this._xdb_verify_unsafe_();
/* 380 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 386 */       MultiRoleMounts.this._xdb_verify_unsafe_();
/* 387 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 393 */       MultiRoleMounts.this._xdb_verify_unsafe_();
/* 394 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 400 */       return MultiRoleMounts.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 406 */       return MultiRoleMounts.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 412 */       MultiRoleMounts.this._xdb_verify_unsafe_();
/* 413 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 419 */       return MultiRoleMounts.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 425 */       return MultiRoleMounts.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 431 */       MultiRoleMounts.this._xdb_verify_unsafe_();
/* 432 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 438 */       return MultiRoleMounts.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 444 */       return MultiRoleMounts.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 450 */       return MultiRoleMounts.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 456 */       return MultiRoleMounts.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 462 */       return MultiRoleMounts.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 468 */       return MultiRoleMounts.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 474 */       return MultiRoleMounts.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.MultiRoleMounts
/*     */   {
/*     */     private int mounts_cfg_id;
/*     */     
/*     */     private ArrayList<Long> role_ids;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 488 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 493 */       this.role_ids = new ArrayList();
/*     */     }
/*     */     
/*     */     Data(xbean.MultiRoleMounts _o1_)
/*     */     {
/* 498 */       if ((_o1_ instanceof MultiRoleMounts)) { assign((MultiRoleMounts)_o1_);
/* 499 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 500 */       } else if ((_o1_ instanceof MultiRoleMounts.Const)) assign(((MultiRoleMounts.Const)_o1_).nThis()); else {
/* 501 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(MultiRoleMounts _o_) {
/* 506 */       this.mounts_cfg_id = _o_.mounts_cfg_id;
/* 507 */       this.role_ids = new ArrayList();
/* 508 */       this.role_ids.addAll(_o_.role_ids);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 513 */       this.mounts_cfg_id = _o_.mounts_cfg_id;
/* 514 */       this.role_ids = new ArrayList();
/* 515 */       this.role_ids.addAll(_o_.role_ids);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 521 */       _os_.marshal(this.mounts_cfg_id);
/* 522 */       _os_.compact_uint32(this.role_ids.size());
/* 523 */       for (Long _v_ : this.role_ids)
/*     */       {
/* 525 */         _os_.marshal(_v_.longValue());
/*     */       }
/* 527 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 533 */       this.mounts_cfg_id = _os_.unmarshal_int();
/* 534 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 536 */         long _v_ = 0L;
/* 537 */         _v_ = _os_.unmarshal_long();
/* 538 */         this.role_ids.add(Long.valueOf(_v_));
/*     */       }
/* 540 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 546 */       int _size_ = 0;
/* 547 */       _size_ += CodedOutputStream.computeInt32Size(1, this.mounts_cfg_id);
/* 548 */       for (Long _v_ : this.role_ids)
/*     */       {
/* 550 */         _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*     */       }
/* 552 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 560 */         _output_.writeInt32(1, this.mounts_cfg_id);
/* 561 */         for (Long _v_ : this.role_ids)
/*     */         {
/* 563 */           _output_.writeInt64(2, _v_.longValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 568 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 570 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 578 */         boolean done = false;
/* 579 */         while (!done)
/*     */         {
/* 581 */           int tag = _input_.readTag();
/* 582 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 586 */             done = true;
/* 587 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 591 */             this.mounts_cfg_id = _input_.readInt32();
/* 592 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 596 */             long _v_ = 0L;
/* 597 */             _v_ = _input_.readInt64();
/* 598 */             this.role_ids.add(Long.valueOf(_v_));
/* 599 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 603 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 605 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 614 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 618 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 620 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MultiRoleMounts copy()
/*     */     {
/* 626 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MultiRoleMounts toData()
/*     */     {
/* 632 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.MultiRoleMounts toBean()
/*     */     {
/* 637 */       return new MultiRoleMounts(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MultiRoleMounts toDataIf()
/*     */     {
/* 643 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.MultiRoleMounts toBeanIf()
/*     */     {
/* 648 */       return new MultiRoleMounts(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 654 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 658 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 662 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 666 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 670 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 674 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 678 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getMounts_cfg_id()
/*     */     {
/* 685 */       return this.mounts_cfg_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getRole_ids()
/*     */     {
/* 692 */       return this.role_ids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getRole_idsAsData()
/*     */     {
/* 699 */       return this.role_ids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMounts_cfg_id(int _v_)
/*     */     {
/* 706 */       this.mounts_cfg_id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 712 */       if (!(_o1_ instanceof Data)) return false;
/* 713 */       Data _o_ = (Data)_o1_;
/* 714 */       if (this.mounts_cfg_id != _o_.mounts_cfg_id) return false;
/* 715 */       if (!this.role_ids.equals(_o_.role_ids)) return false;
/* 716 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 722 */       int _h_ = 0;
/* 723 */       _h_ += this.mounts_cfg_id;
/* 724 */       _h_ += this.role_ids.hashCode();
/* 725 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 731 */       StringBuilder _sb_ = new StringBuilder();
/* 732 */       _sb_.append("(");
/* 733 */       _sb_.append(this.mounts_cfg_id);
/* 734 */       _sb_.append(",");
/* 735 */       _sb_.append(this.role_ids);
/* 736 */       _sb_.append(")");
/* 737 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MultiRoleMounts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */