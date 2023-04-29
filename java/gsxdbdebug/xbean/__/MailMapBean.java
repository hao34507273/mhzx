/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class MailMapBean extends XBean implements xbean.MailMapBean
/*     */ {
/*     */   private HashMap<Integer, xbean.MailInfo> mailinfomap;
/*     */   private int nextid;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.mailinfomap.clear();
/*  21 */     this.nextid = 0;
/*     */   }
/*     */   
/*     */   MailMapBean(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.mailinfomap = new HashMap();
/*  28 */     this.nextid = 0;
/*     */   }
/*     */   
/*     */   public MailMapBean()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public MailMapBean(MailMapBean _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   MailMapBean(xbean.MailMapBean _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof MailMapBean)) { assign((MailMapBean)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(MailMapBean _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.mailinfomap = new HashMap();
/*  54 */     for (Map.Entry<Integer, xbean.MailInfo> _e_ : _o_.mailinfomap.entrySet())
/*  55 */       this.mailinfomap.put(_e_.getKey(), new MailInfo((xbean.MailInfo)_e_.getValue(), this, "mailinfomap"));
/*  56 */     this.nextid = _o_.nextid;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  61 */     this.mailinfomap = new HashMap();
/*  62 */     for (Map.Entry<Integer, xbean.MailInfo> _e_ : _o_.mailinfomap.entrySet())
/*  63 */       this.mailinfomap.put(_e_.getKey(), new MailInfo((xbean.MailInfo)_e_.getValue(), this, "mailinfomap"));
/*  64 */     this.nextid = _o_.nextid;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  70 */     _xdb_verify_unsafe_();
/*  71 */     _os_.compact_uint32(this.mailinfomap.size());
/*  72 */     for (Map.Entry<Integer, xbean.MailInfo> _e_ : this.mailinfomap.entrySet())
/*     */     {
/*  74 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  75 */       ((xbean.MailInfo)_e_.getValue()).marshal(_os_);
/*     */     }
/*  77 */     _os_.marshal(this.nextid);
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  84 */     _xdb_verify_unsafe_();
/*     */     
/*  86 */     int size = _os_.uncompact_uint32();
/*  87 */     if (size >= 12)
/*     */     {
/*  89 */       this.mailinfomap = new HashMap(size * 2);
/*     */     }
/*  91 */     for (; size > 0; size--)
/*     */     {
/*  93 */       int _k_ = 0;
/*  94 */       _k_ = _os_.unmarshal_int();
/*  95 */       xbean.MailInfo _v_ = new MailInfo(0, this, "mailinfomap");
/*  96 */       _v_.unmarshal(_os_);
/*  97 */       this.mailinfomap.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 100 */     this.nextid = _os_.unmarshal_int();
/* 101 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 107 */     _xdb_verify_unsafe_();
/* 108 */     int _size_ = 0;
/* 109 */     for (Map.Entry<Integer, xbean.MailInfo> _e_ : this.mailinfomap.entrySet())
/*     */     {
/* 111 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 112 */       _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */     }
/* 114 */     _size_ += CodedOutputStream.computeInt32Size(2, this.nextid);
/* 115 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 121 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 124 */       for (Map.Entry<Integer, xbean.MailInfo> _e_ : this.mailinfomap.entrySet())
/*     */       {
/* 126 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 127 */         _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 129 */       _output_.writeInt32(2, this.nextid);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 133 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 135 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 141 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 144 */       boolean done = false;
/* 145 */       while (!done)
/*     */       {
/* 147 */         int tag = _input_.readTag();
/* 148 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 152 */           done = true;
/* 153 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 157 */           int _k_ = 0;
/* 158 */           _k_ = _input_.readInt32();
/* 159 */           int readTag = _input_.readTag();
/* 160 */           if (10 != readTag)
/*     */           {
/* 162 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 164 */           xbean.MailInfo _v_ = new MailInfo(0, this, "mailinfomap");
/* 165 */           _input_.readMessage(_v_);
/* 166 */           this.mailinfomap.put(Integer.valueOf(_k_), _v_);
/* 167 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 171 */           this.nextid = _input_.readInt32();
/* 172 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 176 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 178 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 187 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 191 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 193 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MailMapBean copy()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return new MailMapBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MailMapBean toData()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MailMapBean toBean()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new MailMapBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MailMapBean toDataIf()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MailMapBean toBeanIf()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.MailInfo> getMailinfomap()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return xdb.Logs.logMap(new xdb.LogKey(this, "mailinfomap"), this.mailinfomap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.MailInfo> getMailinfomapAsData()
/*     */   {
/* 248 */     _xdb_verify_unsafe_();
/*     */     
/* 250 */     MailMapBean _o_ = this;
/* 251 */     Map<Integer, xbean.MailInfo> mailinfomap = new HashMap();
/* 252 */     for (Map.Entry<Integer, xbean.MailInfo> _e_ : _o_.mailinfomap.entrySet())
/* 253 */       mailinfomap.put(_e_.getKey(), new MailInfo.Data((xbean.MailInfo)_e_.getValue()));
/* 254 */     return mailinfomap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getNextid()
/*     */   {
/* 261 */     _xdb_verify_unsafe_();
/* 262 */     return this.nextid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setNextid(int _v_)
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     xdb.Logs.logIf(new xdb.LogKey(this, "nextid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 274 */         new xdb.logs.LogInt(this, MailMapBean.this.nextid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 278 */             MailMapBean.this.nextid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 282 */     });
/* 283 */     this.nextid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 289 */     _xdb_verify_unsafe_();
/* 290 */     MailMapBean _o_ = null;
/* 291 */     if ((_o1_ instanceof MailMapBean)) { _o_ = (MailMapBean)_o1_;
/* 292 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 293 */       return false;
/* 294 */     if (!this.mailinfomap.equals(_o_.mailinfomap)) return false;
/* 295 */     if (this.nextid != _o_.nextid) return false;
/* 296 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 302 */     _xdb_verify_unsafe_();
/* 303 */     int _h_ = 0;
/* 304 */     _h_ += this.mailinfomap.hashCode();
/* 305 */     _h_ += this.nextid;
/* 306 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     StringBuilder _sb_ = new StringBuilder();
/* 314 */     _sb_.append("(");
/* 315 */     _sb_.append(this.mailinfomap);
/* 316 */     _sb_.append(",");
/* 317 */     _sb_.append(this.nextid);
/* 318 */     _sb_.append(")");
/* 319 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 325 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 326 */     lb.add(new xdb.logs.ListenableMap().setVarName("mailinfomap"));
/* 327 */     lb.add(new xdb.logs.ListenableChanged().setVarName("nextid"));
/* 328 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.MailMapBean {
/*     */     private Const() {}
/*     */     
/*     */     MailMapBean nThis() {
/* 335 */       return MailMapBean.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 341 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MailMapBean copy()
/*     */     {
/* 347 */       return MailMapBean.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MailMapBean toData()
/*     */     {
/* 353 */       return MailMapBean.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.MailMapBean toBean()
/*     */     {
/* 358 */       return MailMapBean.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MailMapBean toDataIf()
/*     */     {
/* 364 */       return MailMapBean.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.MailMapBean toBeanIf()
/*     */     {
/* 369 */       return MailMapBean.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.MailInfo> getMailinfomap()
/*     */     {
/* 376 */       MailMapBean.this._xdb_verify_unsafe_();
/* 377 */       return xdb.Consts.constMap(MailMapBean.this.mailinfomap);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.MailInfo> getMailinfomapAsData()
/*     */     {
/* 384 */       MailMapBean.this._xdb_verify_unsafe_();
/*     */       
/* 386 */       MailMapBean _o_ = MailMapBean.this;
/* 387 */       Map<Integer, xbean.MailInfo> mailinfomap = new HashMap();
/* 388 */       for (Map.Entry<Integer, xbean.MailInfo> _e_ : _o_.mailinfomap.entrySet())
/* 389 */         mailinfomap.put(_e_.getKey(), new MailInfo.Data((xbean.MailInfo)_e_.getValue()));
/* 390 */       return mailinfomap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getNextid()
/*     */     {
/* 397 */       MailMapBean.this._xdb_verify_unsafe_();
/* 398 */       return MailMapBean.this.nextid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setNextid(int _v_)
/*     */     {
/* 405 */       MailMapBean.this._xdb_verify_unsafe_();
/* 406 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 412 */       MailMapBean.this._xdb_verify_unsafe_();
/* 413 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 419 */       MailMapBean.this._xdb_verify_unsafe_();
/* 420 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 426 */       return MailMapBean.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 432 */       return MailMapBean.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 438 */       MailMapBean.this._xdb_verify_unsafe_();
/* 439 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 445 */       return MailMapBean.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 451 */       return MailMapBean.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 457 */       MailMapBean.this._xdb_verify_unsafe_();
/* 458 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 464 */       return MailMapBean.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 470 */       return MailMapBean.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 476 */       return MailMapBean.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 482 */       return MailMapBean.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 488 */       return MailMapBean.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 494 */       return MailMapBean.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 500 */       return MailMapBean.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.MailMapBean
/*     */   {
/*     */     private HashMap<Integer, xbean.MailInfo> mailinfomap;
/*     */     
/*     */     private int nextid;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 514 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 519 */       this.mailinfomap = new HashMap();
/* 520 */       this.nextid = 0;
/*     */     }
/*     */     
/*     */     Data(xbean.MailMapBean _o1_)
/*     */     {
/* 525 */       if ((_o1_ instanceof MailMapBean)) { assign((MailMapBean)_o1_);
/* 526 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 527 */       } else if ((_o1_ instanceof MailMapBean.Const)) assign(((MailMapBean.Const)_o1_).nThis()); else {
/* 528 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(MailMapBean _o_) {
/* 533 */       this.mailinfomap = new HashMap();
/* 534 */       for (Map.Entry<Integer, xbean.MailInfo> _e_ : _o_.mailinfomap.entrySet())
/* 535 */         this.mailinfomap.put(_e_.getKey(), new MailInfo.Data((xbean.MailInfo)_e_.getValue()));
/* 536 */       this.nextid = _o_.nextid;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 541 */       this.mailinfomap = new HashMap();
/* 542 */       for (Map.Entry<Integer, xbean.MailInfo> _e_ : _o_.mailinfomap.entrySet())
/* 543 */         this.mailinfomap.put(_e_.getKey(), new MailInfo.Data((xbean.MailInfo)_e_.getValue()));
/* 544 */       this.nextid = _o_.nextid;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 550 */       _os_.compact_uint32(this.mailinfomap.size());
/* 551 */       for (Map.Entry<Integer, xbean.MailInfo> _e_ : this.mailinfomap.entrySet())
/*     */       {
/* 553 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 554 */         ((xbean.MailInfo)_e_.getValue()).marshal(_os_);
/*     */       }
/* 556 */       _os_.marshal(this.nextid);
/* 557 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 564 */       int size = _os_.uncompact_uint32();
/* 565 */       if (size >= 12)
/*     */       {
/* 567 */         this.mailinfomap = new HashMap(size * 2);
/*     */       }
/* 569 */       for (; size > 0; size--)
/*     */       {
/* 571 */         int _k_ = 0;
/* 572 */         _k_ = _os_.unmarshal_int();
/* 573 */         xbean.MailInfo _v_ = xbean.Pod.newMailInfoData();
/* 574 */         _v_.unmarshal(_os_);
/* 575 */         this.mailinfomap.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 578 */       this.nextid = _os_.unmarshal_int();
/* 579 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 585 */       int _size_ = 0;
/* 586 */       for (Map.Entry<Integer, xbean.MailInfo> _e_ : this.mailinfomap.entrySet())
/*     */       {
/* 588 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 589 */         _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 591 */       _size_ += CodedOutputStream.computeInt32Size(2, this.nextid);
/* 592 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 600 */         for (Map.Entry<Integer, xbean.MailInfo> _e_ : this.mailinfomap.entrySet())
/*     */         {
/* 602 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 603 */           _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */         }
/* 605 */         _output_.writeInt32(2, this.nextid);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 609 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 611 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 619 */         boolean done = false;
/* 620 */         while (!done)
/*     */         {
/* 622 */           int tag = _input_.readTag();
/* 623 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 627 */             done = true;
/* 628 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 632 */             int _k_ = 0;
/* 633 */             _k_ = _input_.readInt32();
/* 634 */             int readTag = _input_.readTag();
/* 635 */             if (10 != readTag)
/*     */             {
/* 637 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 639 */             xbean.MailInfo _v_ = xbean.Pod.newMailInfoData();
/* 640 */             _input_.readMessage(_v_);
/* 641 */             this.mailinfomap.put(Integer.valueOf(_k_), _v_);
/* 642 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 646 */             this.nextid = _input_.readInt32();
/* 647 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 651 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 653 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 662 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 666 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 668 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MailMapBean copy()
/*     */     {
/* 674 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MailMapBean toData()
/*     */     {
/* 680 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.MailMapBean toBean()
/*     */     {
/* 685 */       return new MailMapBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MailMapBean toDataIf()
/*     */     {
/* 691 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.MailMapBean toBeanIf()
/*     */     {
/* 696 */       return new MailMapBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 702 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 706 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 710 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 714 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 718 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 722 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 726 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.MailInfo> getMailinfomap()
/*     */     {
/* 733 */       return this.mailinfomap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.MailInfo> getMailinfomapAsData()
/*     */     {
/* 740 */       return this.mailinfomap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getNextid()
/*     */     {
/* 747 */       return this.nextid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setNextid(int _v_)
/*     */     {
/* 754 */       this.nextid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 760 */       if (!(_o1_ instanceof Data)) return false;
/* 761 */       Data _o_ = (Data)_o1_;
/* 762 */       if (!this.mailinfomap.equals(_o_.mailinfomap)) return false;
/* 763 */       if (this.nextid != _o_.nextid) return false;
/* 764 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 770 */       int _h_ = 0;
/* 771 */       _h_ += this.mailinfomap.hashCode();
/* 772 */       _h_ += this.nextid;
/* 773 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 779 */       StringBuilder _sb_ = new StringBuilder();
/* 780 */       _sb_.append("(");
/* 781 */       _sb_.append(this.mailinfomap);
/* 782 */       _sb_.append(",");
/* 783 */       _sb_.append(this.nextid);
/* 784 */       _sb_.append(")");
/* 785 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MailMapBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */