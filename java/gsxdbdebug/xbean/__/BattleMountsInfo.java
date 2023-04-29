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
/*     */ public final class BattleMountsInfo extends XBean implements xbean.BattleMountsInfo
/*     */ {
/*     */   private long mounts_id;
/*     */   private ArrayList<Long> protect_pet_id_list;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.mounts_id = 0L;
/*  21 */     this.protect_pet_id_list.clear();
/*     */   }
/*     */   
/*     */   BattleMountsInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.protect_pet_id_list = new ArrayList();
/*     */   }
/*     */   
/*     */   public BattleMountsInfo()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public BattleMountsInfo(BattleMountsInfo _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   BattleMountsInfo(xbean.BattleMountsInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof BattleMountsInfo)) { assign((BattleMountsInfo)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(BattleMountsInfo _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.mounts_id = _o_.mounts_id;
/*  53 */     this.protect_pet_id_list = new ArrayList();
/*  54 */     this.protect_pet_id_list.addAll(_o_.protect_pet_id_list);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  59 */     this.mounts_id = _o_.mounts_id;
/*  60 */     this.protect_pet_id_list = new ArrayList();
/*  61 */     this.protect_pet_id_list.addAll(_o_.protect_pet_id_list);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  67 */     _xdb_verify_unsafe_();
/*  68 */     _os_.marshal(this.mounts_id);
/*  69 */     _os_.compact_uint32(this.protect_pet_id_list.size());
/*  70 */     for (Long _v_ : this.protect_pet_id_list)
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
/*  81 */     this.mounts_id = _os_.unmarshal_long();
/*  82 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  84 */       long _v_ = 0L;
/*  85 */       _v_ = _os_.unmarshal_long();
/*  86 */       this.protect_pet_id_list.add(Long.valueOf(_v_));
/*     */     }
/*  88 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  94 */     _xdb_verify_unsafe_();
/*  95 */     int _size_ = 0;
/*  96 */     _size_ += CodedOutputStream.computeInt64Size(1, this.mounts_id);
/*  97 */     for (Long _v_ : this.protect_pet_id_list)
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
/* 110 */       _output_.writeInt64(1, this.mounts_id);
/* 111 */       for (Long _v_ : this.protect_pet_id_list)
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
/* 142 */           this.mounts_id = _input_.readInt64();
/* 143 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 147 */           long _v_ = 0L;
/* 148 */           _v_ = _input_.readInt64();
/* 149 */           this.protect_pet_id_list.add(Long.valueOf(_v_));
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
/*     */   public xbean.BattleMountsInfo copy()
/*     */   {
/* 177 */     _xdb_verify_unsafe_();
/* 178 */     return new BattleMountsInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.BattleMountsInfo toData()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.BattleMountsInfo toBean()
/*     */   {
/* 190 */     _xdb_verify_unsafe_();
/* 191 */     return new BattleMountsInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.BattleMountsInfo toDataIf()
/*     */   {
/* 197 */     _xdb_verify_unsafe_();
/* 198 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.BattleMountsInfo toBeanIf()
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
/*     */   public long getMounts_id()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return this.mounts_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Long> getProtect_pet_id_list()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return xdb.Logs.logList(new LogKey(this, "protect_pet_id_list"), this.protect_pet_id_list);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Long> getProtect_pet_id_listAsData()
/*     */   {
/* 233 */     _xdb_verify_unsafe_();
/*     */     
/* 235 */     BattleMountsInfo _o_ = this;
/* 236 */     List<Long> protect_pet_id_list = new ArrayList();
/* 237 */     protect_pet_id_list.addAll(_o_.protect_pet_id_list);
/* 238 */     return protect_pet_id_list;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMounts_id(long _v_)
/*     */   {
/* 245 */     _xdb_verify_unsafe_();
/* 246 */     xdb.Logs.logIf(new LogKey(this, "mounts_id")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 250 */         new xdb.logs.LogLong(this, BattleMountsInfo.this.mounts_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 254 */             BattleMountsInfo.this.mounts_id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 258 */     });
/* 259 */     this.mounts_id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 265 */     _xdb_verify_unsafe_();
/* 266 */     BattleMountsInfo _o_ = null;
/* 267 */     if ((_o1_ instanceof BattleMountsInfo)) { _o_ = (BattleMountsInfo)_o1_;
/* 268 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 269 */       return false;
/* 270 */     if (this.mounts_id != _o_.mounts_id) return false;
/* 271 */     if (!this.protect_pet_id_list.equals(_o_.protect_pet_id_list)) return false;
/* 272 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     int _h_ = 0;
/* 280 */     _h_ = (int)(_h_ + this.mounts_id);
/* 281 */     _h_ += this.protect_pet_id_list.hashCode();
/* 282 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     StringBuilder _sb_ = new StringBuilder();
/* 290 */     _sb_.append("(");
/* 291 */     _sb_.append(this.mounts_id);
/* 292 */     _sb_.append(",");
/* 293 */     _sb_.append(this.protect_pet_id_list);
/* 294 */     _sb_.append(")");
/* 295 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 301 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 302 */     lb.add(new xdb.logs.ListenableChanged().setVarName("mounts_id"));
/* 303 */     lb.add(new xdb.logs.ListenableChanged().setVarName("protect_pet_id_list"));
/* 304 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.BattleMountsInfo {
/*     */     private Const() {}
/*     */     
/*     */     BattleMountsInfo nThis() {
/* 311 */       return BattleMountsInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 317 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BattleMountsInfo copy()
/*     */     {
/* 323 */       return BattleMountsInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BattleMountsInfo toData()
/*     */     {
/* 329 */       return BattleMountsInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.BattleMountsInfo toBean()
/*     */     {
/* 334 */       return BattleMountsInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BattleMountsInfo toDataIf()
/*     */     {
/* 340 */       return BattleMountsInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.BattleMountsInfo toBeanIf()
/*     */     {
/* 345 */       return BattleMountsInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getMounts_id()
/*     */     {
/* 352 */       BattleMountsInfo.this._xdb_verify_unsafe_();
/* 353 */       return BattleMountsInfo.this.mounts_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getProtect_pet_id_list()
/*     */     {
/* 360 */       BattleMountsInfo.this._xdb_verify_unsafe_();
/* 361 */       return xdb.Consts.constList(BattleMountsInfo.this.protect_pet_id_list);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Long> getProtect_pet_id_listAsData()
/*     */     {
/* 367 */       BattleMountsInfo.this._xdb_verify_unsafe_();
/*     */       
/* 369 */       BattleMountsInfo _o_ = BattleMountsInfo.this;
/* 370 */       List<Long> protect_pet_id_list = new ArrayList();
/* 371 */       protect_pet_id_list.addAll(_o_.protect_pet_id_list);
/* 372 */       return protect_pet_id_list;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMounts_id(long _v_)
/*     */     {
/* 379 */       BattleMountsInfo.this._xdb_verify_unsafe_();
/* 380 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 386 */       BattleMountsInfo.this._xdb_verify_unsafe_();
/* 387 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 393 */       BattleMountsInfo.this._xdb_verify_unsafe_();
/* 394 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 400 */       return BattleMountsInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 406 */       return BattleMountsInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 412 */       BattleMountsInfo.this._xdb_verify_unsafe_();
/* 413 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 419 */       return BattleMountsInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 425 */       return BattleMountsInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 431 */       BattleMountsInfo.this._xdb_verify_unsafe_();
/* 432 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 438 */       return BattleMountsInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 444 */       return BattleMountsInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 450 */       return BattleMountsInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 456 */       return BattleMountsInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 462 */       return BattleMountsInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 468 */       return BattleMountsInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 474 */       return BattleMountsInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.BattleMountsInfo
/*     */   {
/*     */     private long mounts_id;
/*     */     
/*     */     private ArrayList<Long> protect_pet_id_list;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 488 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 493 */       this.protect_pet_id_list = new ArrayList();
/*     */     }
/*     */     
/*     */     Data(xbean.BattleMountsInfo _o1_)
/*     */     {
/* 498 */       if ((_o1_ instanceof BattleMountsInfo)) { assign((BattleMountsInfo)_o1_);
/* 499 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 500 */       } else if ((_o1_ instanceof BattleMountsInfo.Const)) assign(((BattleMountsInfo.Const)_o1_).nThis()); else {
/* 501 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(BattleMountsInfo _o_) {
/* 506 */       this.mounts_id = _o_.mounts_id;
/* 507 */       this.protect_pet_id_list = new ArrayList();
/* 508 */       this.protect_pet_id_list.addAll(_o_.protect_pet_id_list);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 513 */       this.mounts_id = _o_.mounts_id;
/* 514 */       this.protect_pet_id_list = new ArrayList();
/* 515 */       this.protect_pet_id_list.addAll(_o_.protect_pet_id_list);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 521 */       _os_.marshal(this.mounts_id);
/* 522 */       _os_.compact_uint32(this.protect_pet_id_list.size());
/* 523 */       for (Long _v_ : this.protect_pet_id_list)
/*     */       {
/* 525 */         _os_.marshal(_v_.longValue());
/*     */       }
/* 527 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 533 */       this.mounts_id = _os_.unmarshal_long();
/* 534 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 536 */         long _v_ = 0L;
/* 537 */         _v_ = _os_.unmarshal_long();
/* 538 */         this.protect_pet_id_list.add(Long.valueOf(_v_));
/*     */       }
/* 540 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 546 */       int _size_ = 0;
/* 547 */       _size_ += CodedOutputStream.computeInt64Size(1, this.mounts_id);
/* 548 */       for (Long _v_ : this.protect_pet_id_list)
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
/* 560 */         _output_.writeInt64(1, this.mounts_id);
/* 561 */         for (Long _v_ : this.protect_pet_id_list)
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
/* 591 */             this.mounts_id = _input_.readInt64();
/* 592 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 596 */             long _v_ = 0L;
/* 597 */             _v_ = _input_.readInt64();
/* 598 */             this.protect_pet_id_list.add(Long.valueOf(_v_));
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
/*     */     public xbean.BattleMountsInfo copy()
/*     */     {
/* 626 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BattleMountsInfo toData()
/*     */     {
/* 632 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.BattleMountsInfo toBean()
/*     */     {
/* 637 */       return new BattleMountsInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BattleMountsInfo toDataIf()
/*     */     {
/* 643 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.BattleMountsInfo toBeanIf()
/*     */     {
/* 648 */       return new BattleMountsInfo(this, null, null);
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
/*     */     public long getMounts_id()
/*     */     {
/* 685 */       return this.mounts_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getProtect_pet_id_list()
/*     */     {
/* 692 */       return this.protect_pet_id_list;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getProtect_pet_id_listAsData()
/*     */     {
/* 699 */       return this.protect_pet_id_list;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMounts_id(long _v_)
/*     */     {
/* 706 */       this.mounts_id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 712 */       if (!(_o1_ instanceof Data)) return false;
/* 713 */       Data _o_ = (Data)_o1_;
/* 714 */       if (this.mounts_id != _o_.mounts_id) return false;
/* 715 */       if (!this.protect_pet_id_list.equals(_o_.protect_pet_id_list)) return false;
/* 716 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 722 */       int _h_ = 0;
/* 723 */       _h_ = (int)(_h_ + this.mounts_id);
/* 724 */       _h_ += this.protect_pet_id_list.hashCode();
/* 725 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 731 */       StringBuilder _sb_ = new StringBuilder();
/* 732 */       _sb_.append("(");
/* 733 */       _sb_.append(this.mounts_id);
/* 734 */       _sb_.append(",");
/* 735 */       _sb_.append(this.protect_pet_id_list);
/* 736 */       _sb_.append(")");
/* 737 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\BattleMountsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */