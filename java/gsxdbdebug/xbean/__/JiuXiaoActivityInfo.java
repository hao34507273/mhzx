/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.XBean;
/*     */ import xdb.util.SetX;
/*     */ 
/*     */ public final class JiuXiaoActivityInfo extends XBean implements xbean.JiuXiaoActivityInfo
/*     */ {
/*     */   private long worldid;
/*     */   private SetX<Integer> winlayers;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.worldid = 0L;
/*  21 */     this.winlayers.clear();
/*     */   }
/*     */   
/*     */   JiuXiaoActivityInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.winlayers = new SetX();
/*     */   }
/*     */   
/*     */   public JiuXiaoActivityInfo()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public JiuXiaoActivityInfo(JiuXiaoActivityInfo _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   JiuXiaoActivityInfo(xbean.JiuXiaoActivityInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof JiuXiaoActivityInfo)) { assign((JiuXiaoActivityInfo)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(JiuXiaoActivityInfo _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.worldid = _o_.worldid;
/*  53 */     this.winlayers = new SetX();
/*  54 */     this.winlayers.addAll(_o_.winlayers);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  59 */     this.worldid = _o_.worldid;
/*  60 */     this.winlayers = new SetX();
/*  61 */     this.winlayers.addAll(_o_.winlayers);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  67 */     _xdb_verify_unsafe_();
/*  68 */     _os_.marshal(this.worldid);
/*  69 */     _os_.compact_uint32(this.winlayers.size());
/*  70 */     for (Integer _v_ : this.winlayers)
/*     */     {
/*  72 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  80 */     _xdb_verify_unsafe_();
/*  81 */     this.worldid = _os_.unmarshal_long();
/*  82 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  84 */       int _v_ = 0;
/*  85 */       _v_ = _os_.unmarshal_int();
/*  86 */       this.winlayers.add(Integer.valueOf(_v_));
/*     */     }
/*  88 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  94 */     _xdb_verify_unsafe_();
/*  95 */     int _size_ = 0;
/*  96 */     _size_ += CodedOutputStream.computeInt64Size(1, this.worldid);
/*  97 */     for (Integer _v_ : this.winlayers)
/*     */     {
/*  99 */       _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
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
/* 110 */       _output_.writeInt64(1, this.worldid);
/* 111 */       for (Integer _v_ : this.winlayers)
/*     */       {
/* 113 */         _output_.writeInt32(2, _v_.intValue());
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
/* 142 */           this.worldid = _input_.readInt64();
/* 143 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 147 */           int _v_ = 0;
/* 148 */           _v_ = _input_.readInt32();
/* 149 */           this.winlayers.add(Integer.valueOf(_v_));
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
/*     */   public xbean.JiuXiaoActivityInfo copy()
/*     */   {
/* 177 */     _xdb_verify_unsafe_();
/* 178 */     return new JiuXiaoActivityInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.JiuXiaoActivityInfo toData()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.JiuXiaoActivityInfo toBean()
/*     */   {
/* 190 */     _xdb_verify_unsafe_();
/* 191 */     return new JiuXiaoActivityInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.JiuXiaoActivityInfo toDataIf()
/*     */   {
/* 197 */     _xdb_verify_unsafe_();
/* 198 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.JiuXiaoActivityInfo toBeanIf()
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
/*     */   public long getWorldid()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return this.worldid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Integer> getWinlayers()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return xdb.Logs.logSet(new xdb.LogKey(this, "winlayers"), this.winlayers);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Integer> getWinlayersAsData()
/*     */   {
/* 233 */     _xdb_verify_unsafe_();
/*     */     
/* 235 */     JiuXiaoActivityInfo _o_ = this;
/* 236 */     Set<Integer> winlayers = new SetX();
/* 237 */     winlayers.addAll(_o_.winlayers);
/* 238 */     return winlayers;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setWorldid(long _v_)
/*     */   {
/* 245 */     _xdb_verify_unsafe_();
/* 246 */     xdb.Logs.logIf(new xdb.LogKey(this, "worldid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 250 */         new xdb.logs.LogLong(this, JiuXiaoActivityInfo.this.worldid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 254 */             JiuXiaoActivityInfo.this.worldid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 258 */     });
/* 259 */     this.worldid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 265 */     _xdb_verify_unsafe_();
/* 266 */     JiuXiaoActivityInfo _o_ = null;
/* 267 */     if ((_o1_ instanceof JiuXiaoActivityInfo)) { _o_ = (JiuXiaoActivityInfo)_o1_;
/* 268 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 269 */       return false;
/* 270 */     if (this.worldid != _o_.worldid) return false;
/* 271 */     if (!this.winlayers.equals(_o_.winlayers)) return false;
/* 272 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     int _h_ = 0;
/* 280 */     _h_ = (int)(_h_ + this.worldid);
/* 281 */     _h_ += this.winlayers.hashCode();
/* 282 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     StringBuilder _sb_ = new StringBuilder();
/* 290 */     _sb_.append("(");
/* 291 */     _sb_.append(this.worldid);
/* 292 */     _sb_.append(",");
/* 293 */     _sb_.append(this.winlayers);
/* 294 */     _sb_.append(")");
/* 295 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 301 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 302 */     lb.add(new xdb.logs.ListenableChanged().setVarName("worldid"));
/* 303 */     lb.add(new xdb.logs.ListenableSet().setVarName("winlayers"));
/* 304 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.JiuXiaoActivityInfo {
/*     */     private Const() {}
/*     */     
/*     */     JiuXiaoActivityInfo nThis() {
/* 311 */       return JiuXiaoActivityInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 317 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.JiuXiaoActivityInfo copy()
/*     */     {
/* 323 */       return JiuXiaoActivityInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.JiuXiaoActivityInfo toData()
/*     */     {
/* 329 */       return JiuXiaoActivityInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.JiuXiaoActivityInfo toBean()
/*     */     {
/* 334 */       return JiuXiaoActivityInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.JiuXiaoActivityInfo toDataIf()
/*     */     {
/* 340 */       return JiuXiaoActivityInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.JiuXiaoActivityInfo toBeanIf()
/*     */     {
/* 345 */       return JiuXiaoActivityInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getWorldid()
/*     */     {
/* 352 */       JiuXiaoActivityInfo.this._xdb_verify_unsafe_();
/* 353 */       return JiuXiaoActivityInfo.this.worldid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getWinlayers()
/*     */     {
/* 360 */       JiuXiaoActivityInfo.this._xdb_verify_unsafe_();
/* 361 */       return xdb.Consts.constSet(JiuXiaoActivityInfo.this.winlayers);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Integer> getWinlayersAsData()
/*     */     {
/* 367 */       JiuXiaoActivityInfo.this._xdb_verify_unsafe_();
/*     */       
/* 369 */       JiuXiaoActivityInfo _o_ = JiuXiaoActivityInfo.this;
/* 370 */       Set<Integer> winlayers = new SetX();
/* 371 */       winlayers.addAll(_o_.winlayers);
/* 372 */       return winlayers;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setWorldid(long _v_)
/*     */     {
/* 379 */       JiuXiaoActivityInfo.this._xdb_verify_unsafe_();
/* 380 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 386 */       JiuXiaoActivityInfo.this._xdb_verify_unsafe_();
/* 387 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 393 */       JiuXiaoActivityInfo.this._xdb_verify_unsafe_();
/* 394 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 400 */       return JiuXiaoActivityInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 406 */       return JiuXiaoActivityInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 412 */       JiuXiaoActivityInfo.this._xdb_verify_unsafe_();
/* 413 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 419 */       return JiuXiaoActivityInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 425 */       return JiuXiaoActivityInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 431 */       JiuXiaoActivityInfo.this._xdb_verify_unsafe_();
/* 432 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 438 */       return JiuXiaoActivityInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 444 */       return JiuXiaoActivityInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 450 */       return JiuXiaoActivityInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 456 */       return JiuXiaoActivityInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 462 */       return JiuXiaoActivityInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 468 */       return JiuXiaoActivityInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 474 */       return JiuXiaoActivityInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.JiuXiaoActivityInfo
/*     */   {
/*     */     private long worldid;
/*     */     
/*     */     private HashSet<Integer> winlayers;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 488 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 493 */       this.winlayers = new HashSet();
/*     */     }
/*     */     
/*     */     Data(xbean.JiuXiaoActivityInfo _o1_)
/*     */     {
/* 498 */       if ((_o1_ instanceof JiuXiaoActivityInfo)) { assign((JiuXiaoActivityInfo)_o1_);
/* 499 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 500 */       } else if ((_o1_ instanceof JiuXiaoActivityInfo.Const)) assign(((JiuXiaoActivityInfo.Const)_o1_).nThis()); else {
/* 501 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(JiuXiaoActivityInfo _o_) {
/* 506 */       this.worldid = _o_.worldid;
/* 507 */       this.winlayers = new HashSet();
/* 508 */       this.winlayers.addAll(_o_.winlayers);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 513 */       this.worldid = _o_.worldid;
/* 514 */       this.winlayers = new HashSet();
/* 515 */       this.winlayers.addAll(_o_.winlayers);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 521 */       _os_.marshal(this.worldid);
/* 522 */       _os_.compact_uint32(this.winlayers.size());
/* 523 */       for (Integer _v_ : this.winlayers)
/*     */       {
/* 525 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 527 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 533 */       this.worldid = _os_.unmarshal_long();
/* 534 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 536 */         int _v_ = 0;
/* 537 */         _v_ = _os_.unmarshal_int();
/* 538 */         this.winlayers.add(Integer.valueOf(_v_));
/*     */       }
/* 540 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 546 */       int _size_ = 0;
/* 547 */       _size_ += CodedOutputStream.computeInt64Size(1, this.worldid);
/* 548 */       for (Integer _v_ : this.winlayers)
/*     */       {
/* 550 */         _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*     */       }
/* 552 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 560 */         _output_.writeInt64(1, this.worldid);
/* 561 */         for (Integer _v_ : this.winlayers)
/*     */         {
/* 563 */           _output_.writeInt32(2, _v_.intValue());
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
/* 591 */             this.worldid = _input_.readInt64();
/* 592 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 596 */             int _v_ = 0;
/* 597 */             _v_ = _input_.readInt32();
/* 598 */             this.winlayers.add(Integer.valueOf(_v_));
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
/*     */     public xbean.JiuXiaoActivityInfo copy()
/*     */     {
/* 626 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.JiuXiaoActivityInfo toData()
/*     */     {
/* 632 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.JiuXiaoActivityInfo toBean()
/*     */     {
/* 637 */       return new JiuXiaoActivityInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.JiuXiaoActivityInfo toDataIf()
/*     */     {
/* 643 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.JiuXiaoActivityInfo toBeanIf()
/*     */     {
/* 648 */       return new JiuXiaoActivityInfo(this, null, null);
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
/*     */     public long getWorldid()
/*     */     {
/* 685 */       return this.worldid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getWinlayers()
/*     */     {
/* 692 */       return this.winlayers;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getWinlayersAsData()
/*     */     {
/* 699 */       return this.winlayers;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setWorldid(long _v_)
/*     */     {
/* 706 */       this.worldid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 712 */       if (!(_o1_ instanceof Data)) return false;
/* 713 */       Data _o_ = (Data)_o1_;
/* 714 */       if (this.worldid != _o_.worldid) return false;
/* 715 */       if (!this.winlayers.equals(_o_.winlayers)) return false;
/* 716 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 722 */       int _h_ = 0;
/* 723 */       _h_ = (int)(_h_ + this.worldid);
/* 724 */       _h_ += this.winlayers.hashCode();
/* 725 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 731 */       StringBuilder _sb_ = new StringBuilder();
/* 732 */       _sb_.append("(");
/* 733 */       _sb_.append(this.worldid);
/* 734 */       _sb_.append(",");
/* 735 */       _sb_.append(this.winlayers);
/* 736 */       _sb_.append(")");
/* 737 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\JiuXiaoActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */