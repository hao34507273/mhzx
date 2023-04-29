/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.logs.LogLong;
/*      */ 
/*      */ public final class SaleLog extends XBean implements xbean.SaleLog
/*      */ {
/*      */   private long roleid;
/*      */   private long buytime;
/*      */   private int itemorpetcfgid;
/*      */   private int price;
/*      */   private int num;
/*      */   private long marketid;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.roleid = 0L;
/*   29 */     this.buytime = 0L;
/*   30 */     this.itemorpetcfgid = 0;
/*   31 */     this.price = 0;
/*   32 */     this.num = 0;
/*   33 */     this.marketid = 0L;
/*      */   }
/*      */   
/*      */   SaleLog(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*      */   }
/*      */   
/*      */   public SaleLog()
/*      */   {
/*   43 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public SaleLog(SaleLog _o_)
/*      */   {
/*   48 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   SaleLog(xbean.SaleLog _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   53 */     super(_xp_, _vn_);
/*   54 */     if ((_o1_ instanceof SaleLog)) { assign((SaleLog)_o1_);
/*   55 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   56 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   57 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(SaleLog _o_) {
/*   62 */     _o_._xdb_verify_unsafe_();
/*   63 */     this.roleid = _o_.roleid;
/*   64 */     this.buytime = _o_.buytime;
/*   65 */     this.itemorpetcfgid = _o_.itemorpetcfgid;
/*   66 */     this.price = _o_.price;
/*   67 */     this.num = _o_.num;
/*   68 */     this.marketid = _o_.marketid;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   73 */     this.roleid = _o_.roleid;
/*   74 */     this.buytime = _o_.buytime;
/*   75 */     this.itemorpetcfgid = _o_.itemorpetcfgid;
/*   76 */     this.price = _o_.price;
/*   77 */     this.num = _o_.num;
/*   78 */     this.marketid = _o_.marketid;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   84 */     _xdb_verify_unsafe_();
/*   85 */     _os_.marshal(this.roleid);
/*   86 */     _os_.marshal(this.buytime);
/*   87 */     _os_.marshal(this.itemorpetcfgid);
/*   88 */     _os_.marshal(this.price);
/*   89 */     _os_.marshal(this.num);
/*   90 */     _os_.marshal(this.marketid);
/*   91 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*   97 */     _xdb_verify_unsafe_();
/*   98 */     this.roleid = _os_.unmarshal_long();
/*   99 */     this.buytime = _os_.unmarshal_long();
/*  100 */     this.itemorpetcfgid = _os_.unmarshal_int();
/*  101 */     this.price = _os_.unmarshal_int();
/*  102 */     this.num = _os_.unmarshal_int();
/*  103 */     this.marketid = _os_.unmarshal_long();
/*  104 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  110 */     _xdb_verify_unsafe_();
/*  111 */     int _size_ = 0;
/*  112 */     _size_ += CodedOutputStream.computeInt64Size(1, this.roleid);
/*  113 */     _size_ += CodedOutputStream.computeInt64Size(2, this.buytime);
/*  114 */     _size_ += CodedOutputStream.computeInt32Size(3, this.itemorpetcfgid);
/*  115 */     _size_ += CodedOutputStream.computeInt32Size(4, this.price);
/*  116 */     _size_ += CodedOutputStream.computeInt32Size(5, this.num);
/*  117 */     _size_ += CodedOutputStream.computeInt64Size(6, this.marketid);
/*  118 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  124 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  127 */       _output_.writeInt64(1, this.roleid);
/*  128 */       _output_.writeInt64(2, this.buytime);
/*  129 */       _output_.writeInt32(3, this.itemorpetcfgid);
/*  130 */       _output_.writeInt32(4, this.price);
/*  131 */       _output_.writeInt32(5, this.num);
/*  132 */       _output_.writeInt64(6, this.marketid);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  136 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  138 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  144 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  147 */       boolean done = false;
/*  148 */       while (!done)
/*      */       {
/*  150 */         int tag = _input_.readTag();
/*  151 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  155 */           done = true;
/*  156 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  160 */           this.roleid = _input_.readInt64();
/*  161 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  165 */           this.buytime = _input_.readInt64();
/*  166 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  170 */           this.itemorpetcfgid = _input_.readInt32();
/*  171 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  175 */           this.price = _input_.readInt32();
/*  176 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  180 */           this.num = _input_.readInt32();
/*  181 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  185 */           this.marketid = _input_.readInt64();
/*  186 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  190 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  192 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  201 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  205 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  207 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.SaleLog copy()
/*      */   {
/*  213 */     _xdb_verify_unsafe_();
/*  214 */     return new SaleLog(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.SaleLog toData()
/*      */   {
/*  220 */     _xdb_verify_unsafe_();
/*  221 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.SaleLog toBean()
/*      */   {
/*  226 */     _xdb_verify_unsafe_();
/*  227 */     return new SaleLog(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.SaleLog toDataIf()
/*      */   {
/*  233 */     _xdb_verify_unsafe_();
/*  234 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.SaleLog toBeanIf()
/*      */   {
/*  239 */     _xdb_verify_unsafe_();
/*  240 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  246 */     _xdb_verify_unsafe_();
/*  247 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getRoleid()
/*      */   {
/*  254 */     _xdb_verify_unsafe_();
/*  255 */     return this.roleid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getBuytime()
/*      */   {
/*  262 */     _xdb_verify_unsafe_();
/*  263 */     return this.buytime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getItemorpetcfgid()
/*      */   {
/*  270 */     _xdb_verify_unsafe_();
/*  271 */     return this.itemorpetcfgid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPrice()
/*      */   {
/*  278 */     _xdb_verify_unsafe_();
/*  279 */     return this.price;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getNum()
/*      */   {
/*  286 */     _xdb_verify_unsafe_();
/*  287 */     return this.num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getMarketid()
/*      */   {
/*  294 */     _xdb_verify_unsafe_();
/*  295 */     return this.marketid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRoleid(long _v_)
/*      */   {
/*  302 */     _xdb_verify_unsafe_();
/*  303 */     Logs.logIf(new LogKey(this, "roleid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  307 */         new LogLong(this, SaleLog.this.roleid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  311 */             SaleLog.this.roleid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  315 */     });
/*  316 */     this.roleid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBuytime(long _v_)
/*      */   {
/*  323 */     _xdb_verify_unsafe_();
/*  324 */     Logs.logIf(new LogKey(this, "buytime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  328 */         new LogLong(this, SaleLog.this.buytime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  332 */             SaleLog.this.buytime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  336 */     });
/*  337 */     this.buytime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setItemorpetcfgid(int _v_)
/*      */   {
/*  344 */     _xdb_verify_unsafe_();
/*  345 */     Logs.logIf(new LogKey(this, "itemorpetcfgid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  349 */         new LogInt(this, SaleLog.this.itemorpetcfgid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  353 */             SaleLog.this.itemorpetcfgid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  357 */     });
/*  358 */     this.itemorpetcfgid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPrice(int _v_)
/*      */   {
/*  365 */     _xdb_verify_unsafe_();
/*  366 */     Logs.logIf(new LogKey(this, "price")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  370 */         new LogInt(this, SaleLog.this.price)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  374 */             SaleLog.this.price = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  378 */     });
/*  379 */     this.price = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNum(int _v_)
/*      */   {
/*  386 */     _xdb_verify_unsafe_();
/*  387 */     Logs.logIf(new LogKey(this, "num")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  391 */         new LogInt(this, SaleLog.this.num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  395 */             SaleLog.this.num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  399 */     });
/*  400 */     this.num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMarketid(long _v_)
/*      */   {
/*  407 */     _xdb_verify_unsafe_();
/*  408 */     Logs.logIf(new LogKey(this, "marketid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  412 */         new LogLong(this, SaleLog.this.marketid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  416 */             SaleLog.this.marketid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  420 */     });
/*  421 */     this.marketid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  427 */     _xdb_verify_unsafe_();
/*  428 */     SaleLog _o_ = null;
/*  429 */     if ((_o1_ instanceof SaleLog)) { _o_ = (SaleLog)_o1_;
/*  430 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  431 */       return false;
/*  432 */     if (this.roleid != _o_.roleid) return false;
/*  433 */     if (this.buytime != _o_.buytime) return false;
/*  434 */     if (this.itemorpetcfgid != _o_.itemorpetcfgid) return false;
/*  435 */     if (this.price != _o_.price) return false;
/*  436 */     if (this.num != _o_.num) return false;
/*  437 */     if (this.marketid != _o_.marketid) return false;
/*  438 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  444 */     _xdb_verify_unsafe_();
/*  445 */     int _h_ = 0;
/*  446 */     _h_ = (int)(_h_ + this.roleid);
/*  447 */     _h_ = (int)(_h_ + this.buytime);
/*  448 */     _h_ += this.itemorpetcfgid;
/*  449 */     _h_ += this.price;
/*  450 */     _h_ += this.num;
/*  451 */     _h_ = (int)(_h_ + this.marketid);
/*  452 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  458 */     _xdb_verify_unsafe_();
/*  459 */     StringBuilder _sb_ = new StringBuilder();
/*  460 */     _sb_.append("(");
/*  461 */     _sb_.append(this.roleid);
/*  462 */     _sb_.append(",");
/*  463 */     _sb_.append(this.buytime);
/*  464 */     _sb_.append(",");
/*  465 */     _sb_.append(this.itemorpetcfgid);
/*  466 */     _sb_.append(",");
/*  467 */     _sb_.append(this.price);
/*  468 */     _sb_.append(",");
/*  469 */     _sb_.append(this.num);
/*  470 */     _sb_.append(",");
/*  471 */     _sb_.append(this.marketid);
/*  472 */     _sb_.append(")");
/*  473 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  479 */     ListenableBean lb = new ListenableBean();
/*  480 */     lb.add(new ListenableChanged().setVarName("roleid"));
/*  481 */     lb.add(new ListenableChanged().setVarName("buytime"));
/*  482 */     lb.add(new ListenableChanged().setVarName("itemorpetcfgid"));
/*  483 */     lb.add(new ListenableChanged().setVarName("price"));
/*  484 */     lb.add(new ListenableChanged().setVarName("num"));
/*  485 */     lb.add(new ListenableChanged().setVarName("marketid"));
/*  486 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.SaleLog {
/*      */     private Const() {}
/*      */     
/*      */     SaleLog nThis() {
/*  493 */       return SaleLog.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  499 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SaleLog copy()
/*      */     {
/*  505 */       return SaleLog.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SaleLog toData()
/*      */     {
/*  511 */       return SaleLog.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.SaleLog toBean()
/*      */     {
/*  516 */       return SaleLog.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SaleLog toDataIf()
/*      */     {
/*  522 */       return SaleLog.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.SaleLog toBeanIf()
/*      */     {
/*  527 */       return SaleLog.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleid()
/*      */     {
/*  534 */       SaleLog.this._xdb_verify_unsafe_();
/*  535 */       return SaleLog.this.roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBuytime()
/*      */     {
/*  542 */       SaleLog.this._xdb_verify_unsafe_();
/*  543 */       return SaleLog.this.buytime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getItemorpetcfgid()
/*      */     {
/*  550 */       SaleLog.this._xdb_verify_unsafe_();
/*  551 */       return SaleLog.this.itemorpetcfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPrice()
/*      */     {
/*  558 */       SaleLog.this._xdb_verify_unsafe_();
/*  559 */       return SaleLog.this.price;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getNum()
/*      */     {
/*  566 */       SaleLog.this._xdb_verify_unsafe_();
/*  567 */       return SaleLog.this.num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMarketid()
/*      */     {
/*  574 */       SaleLog.this._xdb_verify_unsafe_();
/*  575 */       return SaleLog.this.marketid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleid(long _v_)
/*      */     {
/*  582 */       SaleLog.this._xdb_verify_unsafe_();
/*  583 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBuytime(long _v_)
/*      */     {
/*  590 */       SaleLog.this._xdb_verify_unsafe_();
/*  591 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setItemorpetcfgid(int _v_)
/*      */     {
/*  598 */       SaleLog.this._xdb_verify_unsafe_();
/*  599 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPrice(int _v_)
/*      */     {
/*  606 */       SaleLog.this._xdb_verify_unsafe_();
/*  607 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNum(int _v_)
/*      */     {
/*  614 */       SaleLog.this._xdb_verify_unsafe_();
/*  615 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMarketid(long _v_)
/*      */     {
/*  622 */       SaleLog.this._xdb_verify_unsafe_();
/*  623 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  629 */       SaleLog.this._xdb_verify_unsafe_();
/*  630 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  636 */       SaleLog.this._xdb_verify_unsafe_();
/*  637 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  643 */       return SaleLog.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  649 */       return SaleLog.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  655 */       SaleLog.this._xdb_verify_unsafe_();
/*  656 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  662 */       return SaleLog.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  668 */       return SaleLog.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  674 */       SaleLog.this._xdb_verify_unsafe_();
/*  675 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  681 */       return SaleLog.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  687 */       return SaleLog.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  693 */       return SaleLog.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  699 */       return SaleLog.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  705 */       return SaleLog.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  711 */       return SaleLog.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  717 */       return SaleLog.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.SaleLog
/*      */   {
/*      */     private long roleid;
/*      */     
/*      */     private long buytime;
/*      */     
/*      */     private int itemorpetcfgid;
/*      */     
/*      */     private int price;
/*      */     
/*      */     private int num;
/*      */     
/*      */     private long marketid;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  739 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Data() {}
/*      */     
/*      */ 
/*      */     Data(xbean.SaleLog _o1_)
/*      */     {
/*  748 */       if ((_o1_ instanceof SaleLog)) { assign((SaleLog)_o1_);
/*  749 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  750 */       } else if ((_o1_ instanceof SaleLog.Const)) assign(((SaleLog.Const)_o1_).nThis()); else {
/*  751 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(SaleLog _o_) {
/*  756 */       this.roleid = _o_.roleid;
/*  757 */       this.buytime = _o_.buytime;
/*  758 */       this.itemorpetcfgid = _o_.itemorpetcfgid;
/*  759 */       this.price = _o_.price;
/*  760 */       this.num = _o_.num;
/*  761 */       this.marketid = _o_.marketid;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  766 */       this.roleid = _o_.roleid;
/*  767 */       this.buytime = _o_.buytime;
/*  768 */       this.itemorpetcfgid = _o_.itemorpetcfgid;
/*  769 */       this.price = _o_.price;
/*  770 */       this.num = _o_.num;
/*  771 */       this.marketid = _o_.marketid;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  777 */       _os_.marshal(this.roleid);
/*  778 */       _os_.marshal(this.buytime);
/*  779 */       _os_.marshal(this.itemorpetcfgid);
/*  780 */       _os_.marshal(this.price);
/*  781 */       _os_.marshal(this.num);
/*  782 */       _os_.marshal(this.marketid);
/*  783 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  789 */       this.roleid = _os_.unmarshal_long();
/*  790 */       this.buytime = _os_.unmarshal_long();
/*  791 */       this.itemorpetcfgid = _os_.unmarshal_int();
/*  792 */       this.price = _os_.unmarshal_int();
/*  793 */       this.num = _os_.unmarshal_int();
/*  794 */       this.marketid = _os_.unmarshal_long();
/*  795 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  801 */       int _size_ = 0;
/*  802 */       _size_ += CodedOutputStream.computeInt64Size(1, this.roleid);
/*  803 */       _size_ += CodedOutputStream.computeInt64Size(2, this.buytime);
/*  804 */       _size_ += CodedOutputStream.computeInt32Size(3, this.itemorpetcfgid);
/*  805 */       _size_ += CodedOutputStream.computeInt32Size(4, this.price);
/*  806 */       _size_ += CodedOutputStream.computeInt32Size(5, this.num);
/*  807 */       _size_ += CodedOutputStream.computeInt64Size(6, this.marketid);
/*  808 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  816 */         _output_.writeInt64(1, this.roleid);
/*  817 */         _output_.writeInt64(2, this.buytime);
/*  818 */         _output_.writeInt32(3, this.itemorpetcfgid);
/*  819 */         _output_.writeInt32(4, this.price);
/*  820 */         _output_.writeInt32(5, this.num);
/*  821 */         _output_.writeInt64(6, this.marketid);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  825 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  827 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  835 */         boolean done = false;
/*  836 */         while (!done)
/*      */         {
/*  838 */           int tag = _input_.readTag();
/*  839 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  843 */             done = true;
/*  844 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  848 */             this.roleid = _input_.readInt64();
/*  849 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  853 */             this.buytime = _input_.readInt64();
/*  854 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  858 */             this.itemorpetcfgid = _input_.readInt32();
/*  859 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  863 */             this.price = _input_.readInt32();
/*  864 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  868 */             this.num = _input_.readInt32();
/*  869 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  873 */             this.marketid = _input_.readInt64();
/*  874 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  878 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  880 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  889 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  893 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  895 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SaleLog copy()
/*      */     {
/*  901 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SaleLog toData()
/*      */     {
/*  907 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.SaleLog toBean()
/*      */     {
/*  912 */       return new SaleLog(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SaleLog toDataIf()
/*      */     {
/*  918 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.SaleLog toBeanIf()
/*      */     {
/*  923 */       return new SaleLog(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  929 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  933 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  937 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  941 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  945 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  949 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  953 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleid()
/*      */     {
/*  960 */       return this.roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBuytime()
/*      */     {
/*  967 */       return this.buytime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getItemorpetcfgid()
/*      */     {
/*  974 */       return this.itemorpetcfgid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPrice()
/*      */     {
/*  981 */       return this.price;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getNum()
/*      */     {
/*  988 */       return this.num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getMarketid()
/*      */     {
/*  995 */       return this.marketid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleid(long _v_)
/*      */     {
/* 1002 */       this.roleid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBuytime(long _v_)
/*      */     {
/* 1009 */       this.buytime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setItemorpetcfgid(int _v_)
/*      */     {
/* 1016 */       this.itemorpetcfgid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPrice(int _v_)
/*      */     {
/* 1023 */       this.price = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNum(int _v_)
/*      */     {
/* 1030 */       this.num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMarketid(long _v_)
/*      */     {
/* 1037 */       this.marketid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1043 */       if (!(_o1_ instanceof Data)) return false;
/* 1044 */       Data _o_ = (Data)_o1_;
/* 1045 */       if (this.roleid != _o_.roleid) return false;
/* 1046 */       if (this.buytime != _o_.buytime) return false;
/* 1047 */       if (this.itemorpetcfgid != _o_.itemorpetcfgid) return false;
/* 1048 */       if (this.price != _o_.price) return false;
/* 1049 */       if (this.num != _o_.num) return false;
/* 1050 */       if (this.marketid != _o_.marketid) return false;
/* 1051 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1057 */       int _h_ = 0;
/* 1058 */       _h_ = (int)(_h_ + this.roleid);
/* 1059 */       _h_ = (int)(_h_ + this.buytime);
/* 1060 */       _h_ += this.itemorpetcfgid;
/* 1061 */       _h_ += this.price;
/* 1062 */       _h_ += this.num;
/* 1063 */       _h_ = (int)(_h_ + this.marketid);
/* 1064 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1070 */       StringBuilder _sb_ = new StringBuilder();
/* 1071 */       _sb_.append("(");
/* 1072 */       _sb_.append(this.roleid);
/* 1073 */       _sb_.append(",");
/* 1074 */       _sb_.append(this.buytime);
/* 1075 */       _sb_.append(",");
/* 1076 */       _sb_.append(this.itemorpetcfgid);
/* 1077 */       _sb_.append(",");
/* 1078 */       _sb_.append(this.price);
/* 1079 */       _sb_.append(",");
/* 1080 */       _sb_.append(this.num);
/* 1081 */       _sb_.append(",");
/* 1082 */       _sb_.append(this.marketid);
/* 1083 */       _sb_.append(")");
/* 1084 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\SaleLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */