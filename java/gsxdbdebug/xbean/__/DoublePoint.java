/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashSet;
/*      */ import java.util.Set;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class DoublePoint extends XBean implements xbean.DoublePoint
/*      */ {
/*      */   private int gettingpoolpointnum;
/*      */   private int frozenpoolpointnum;
/*      */   private long offertimestamp;
/*      */   private long resetitemusetimestamp;
/*      */   private int itemusecount;
/*      */   private SetX<Integer> switches;
/*      */   private SetX<Integer> switch_inits;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   30 */     this.gettingpoolpointnum = 0;
/*   31 */     this.frozenpoolpointnum = 0;
/*   32 */     this.offertimestamp = 0L;
/*   33 */     this.resetitemusetimestamp = 0L;
/*   34 */     this.itemusecount = 0;
/*   35 */     this.switches.clear();
/*   36 */     this.switch_inits.clear();
/*      */   }
/*      */   
/*      */   DoublePoint(int __, XBean _xp_, String _vn_)
/*      */   {
/*   41 */     super(_xp_, _vn_);
/*   42 */     this.gettingpoolpointnum = 0;
/*   43 */     this.frozenpoolpointnum = 0;
/*   44 */     this.itemusecount = 0;
/*   45 */     this.switches = new SetX();
/*   46 */     this.switch_inits = new SetX();
/*      */   }
/*      */   
/*      */   public DoublePoint()
/*      */   {
/*   51 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public DoublePoint(DoublePoint _o_)
/*      */   {
/*   56 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   DoublePoint(xbean.DoublePoint _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   61 */     super(_xp_, _vn_);
/*   62 */     if ((_o1_ instanceof DoublePoint)) { assign((DoublePoint)_o1_);
/*   63 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   64 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   65 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(DoublePoint _o_) {
/*   70 */     _o_._xdb_verify_unsafe_();
/*   71 */     this.gettingpoolpointnum = _o_.gettingpoolpointnum;
/*   72 */     this.frozenpoolpointnum = _o_.frozenpoolpointnum;
/*   73 */     this.offertimestamp = _o_.offertimestamp;
/*   74 */     this.resetitemusetimestamp = _o_.resetitemusetimestamp;
/*   75 */     this.itemusecount = _o_.itemusecount;
/*   76 */     this.switches = new SetX();
/*   77 */     this.switches.addAll(_o_.switches);
/*   78 */     this.switch_inits = new SetX();
/*   79 */     this.switch_inits.addAll(_o_.switch_inits);
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   84 */     this.gettingpoolpointnum = _o_.gettingpoolpointnum;
/*   85 */     this.frozenpoolpointnum = _o_.frozenpoolpointnum;
/*   86 */     this.offertimestamp = _o_.offertimestamp;
/*   87 */     this.resetitemusetimestamp = _o_.resetitemusetimestamp;
/*   88 */     this.itemusecount = _o_.itemusecount;
/*   89 */     this.switches = new SetX();
/*   90 */     this.switches.addAll(_o_.switches);
/*   91 */     this.switch_inits = new SetX();
/*   92 */     this.switch_inits.addAll(_o_.switch_inits);
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   98 */     _xdb_verify_unsafe_();
/*   99 */     _os_.marshal(this.gettingpoolpointnum);
/*  100 */     _os_.marshal(this.frozenpoolpointnum);
/*  101 */     _os_.marshal(this.offertimestamp);
/*  102 */     _os_.marshal(this.resetitemusetimestamp);
/*  103 */     _os_.marshal(this.itemusecount);
/*  104 */     _os_.compact_uint32(this.switches.size());
/*  105 */     for (Integer _v_ : this.switches)
/*      */     {
/*  107 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  109 */     _os_.compact_uint32(this.switch_inits.size());
/*  110 */     for (Integer _v_ : this.switch_inits)
/*      */     {
/*  112 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  114 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  120 */     _xdb_verify_unsafe_();
/*  121 */     this.gettingpoolpointnum = _os_.unmarshal_int();
/*  122 */     this.frozenpoolpointnum = _os_.unmarshal_int();
/*  123 */     this.offertimestamp = _os_.unmarshal_long();
/*  124 */     this.resetitemusetimestamp = _os_.unmarshal_long();
/*  125 */     this.itemusecount = _os_.unmarshal_int();
/*  126 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  128 */       int _v_ = 0;
/*  129 */       _v_ = _os_.unmarshal_int();
/*  130 */       this.switches.add(Integer.valueOf(_v_));
/*      */     }
/*  132 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  134 */       int _v_ = 0;
/*  135 */       _v_ = _os_.unmarshal_int();
/*  136 */       this.switch_inits.add(Integer.valueOf(_v_));
/*      */     }
/*  138 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  144 */     _xdb_verify_unsafe_();
/*  145 */     int _size_ = 0;
/*  146 */     _size_ += CodedOutputStream.computeInt32Size(1, this.gettingpoolpointnum);
/*  147 */     _size_ += CodedOutputStream.computeInt32Size(2, this.frozenpoolpointnum);
/*  148 */     _size_ += CodedOutputStream.computeInt64Size(3, this.offertimestamp);
/*  149 */     _size_ += CodedOutputStream.computeInt64Size(4, this.resetitemusetimestamp);
/*  150 */     _size_ += CodedOutputStream.computeInt32Size(5, this.itemusecount);
/*  151 */     for (Integer _v_ : this.switches)
/*      */     {
/*  153 */       _size_ += CodedOutputStream.computeInt32Size(6, _v_.intValue());
/*      */     }
/*  155 */     for (Integer _v_ : this.switch_inits)
/*      */     {
/*  157 */       _size_ += CodedOutputStream.computeInt32Size(8, _v_.intValue());
/*      */     }
/*  159 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  165 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  168 */       _output_.writeInt32(1, this.gettingpoolpointnum);
/*  169 */       _output_.writeInt32(2, this.frozenpoolpointnum);
/*  170 */       _output_.writeInt64(3, this.offertimestamp);
/*  171 */       _output_.writeInt64(4, this.resetitemusetimestamp);
/*  172 */       _output_.writeInt32(5, this.itemusecount);
/*  173 */       for (Integer _v_ : this.switches)
/*      */       {
/*  175 */         _output_.writeInt32(6, _v_.intValue());
/*      */       }
/*  177 */       for (Integer _v_ : this.switch_inits)
/*      */       {
/*  179 */         _output_.writeInt32(8, _v_.intValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  184 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  186 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  192 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  195 */       boolean done = false;
/*  196 */       while (!done)
/*      */       {
/*  198 */         int tag = _input_.readTag();
/*  199 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  203 */           done = true;
/*  204 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  208 */           this.gettingpoolpointnum = _input_.readInt32();
/*  209 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  213 */           this.frozenpoolpointnum = _input_.readInt32();
/*  214 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  218 */           this.offertimestamp = _input_.readInt64();
/*  219 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  223 */           this.resetitemusetimestamp = _input_.readInt64();
/*  224 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  228 */           this.itemusecount = _input_.readInt32();
/*  229 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  233 */           int _v_ = 0;
/*  234 */           _v_ = _input_.readInt32();
/*  235 */           this.switches.add(Integer.valueOf(_v_));
/*  236 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  240 */           int _v_ = 0;
/*  241 */           _v_ = _input_.readInt32();
/*  242 */           this.switch_inits.add(Integer.valueOf(_v_));
/*  243 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  247 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  249 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  258 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  262 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  264 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.DoublePoint copy()
/*      */   {
/*  270 */     _xdb_verify_unsafe_();
/*  271 */     return new DoublePoint(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.DoublePoint toData()
/*      */   {
/*  277 */     _xdb_verify_unsafe_();
/*  278 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.DoublePoint toBean()
/*      */   {
/*  283 */     _xdb_verify_unsafe_();
/*  284 */     return new DoublePoint(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.DoublePoint toDataIf()
/*      */   {
/*  290 */     _xdb_verify_unsafe_();
/*  291 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.DoublePoint toBeanIf()
/*      */   {
/*  296 */     _xdb_verify_unsafe_();
/*  297 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  303 */     _xdb_verify_unsafe_();
/*  304 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getGettingpoolpointnum()
/*      */   {
/*  311 */     _xdb_verify_unsafe_();
/*  312 */     return this.gettingpoolpointnum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getFrozenpoolpointnum()
/*      */   {
/*  319 */     _xdb_verify_unsafe_();
/*  320 */     return this.frozenpoolpointnum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getOffertimestamp()
/*      */   {
/*  327 */     _xdb_verify_unsafe_();
/*  328 */     return this.offertimestamp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getResetitemusetimestamp()
/*      */   {
/*  335 */     _xdb_verify_unsafe_();
/*  336 */     return this.resetitemusetimestamp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getItemusecount()
/*      */   {
/*  343 */     _xdb_verify_unsafe_();
/*  344 */     return this.itemusecount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Integer> getSwitches()
/*      */   {
/*  351 */     _xdb_verify_unsafe_();
/*  352 */     return Logs.logSet(new LogKey(this, "switches"), this.switches);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Integer> getSwitchesAsData()
/*      */   {
/*  358 */     _xdb_verify_unsafe_();
/*      */     
/*  360 */     DoublePoint _o_ = this;
/*  361 */     Set<Integer> switches = new SetX();
/*  362 */     switches.addAll(_o_.switches);
/*  363 */     return switches;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Integer> getSwitch_inits()
/*      */   {
/*  370 */     _xdb_verify_unsafe_();
/*  371 */     return Logs.logSet(new LogKey(this, "switch_inits"), this.switch_inits);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Integer> getSwitch_initsAsData()
/*      */   {
/*  377 */     _xdb_verify_unsafe_();
/*      */     
/*  379 */     DoublePoint _o_ = this;
/*  380 */     Set<Integer> switch_inits = new SetX();
/*  381 */     switch_inits.addAll(_o_.switch_inits);
/*  382 */     return switch_inits;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGettingpoolpointnum(int _v_)
/*      */   {
/*  389 */     _xdb_verify_unsafe_();
/*  390 */     Logs.logIf(new LogKey(this, "gettingpoolpointnum")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  394 */         new LogInt(this, DoublePoint.this.gettingpoolpointnum)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  398 */             DoublePoint.this.gettingpoolpointnum = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  402 */     });
/*  403 */     this.gettingpoolpointnum = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFrozenpoolpointnum(int _v_)
/*      */   {
/*  410 */     _xdb_verify_unsafe_();
/*  411 */     Logs.logIf(new LogKey(this, "frozenpoolpointnum")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  415 */         new LogInt(this, DoublePoint.this.frozenpoolpointnum)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  419 */             DoublePoint.this.frozenpoolpointnum = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  423 */     });
/*  424 */     this.frozenpoolpointnum = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setOffertimestamp(long _v_)
/*      */   {
/*  431 */     _xdb_verify_unsafe_();
/*  432 */     Logs.logIf(new LogKey(this, "offertimestamp")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  436 */         new xdb.logs.LogLong(this, DoublePoint.this.offertimestamp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  440 */             DoublePoint.this.offertimestamp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  444 */     });
/*  445 */     this.offertimestamp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setResetitemusetimestamp(long _v_)
/*      */   {
/*  452 */     _xdb_verify_unsafe_();
/*  453 */     Logs.logIf(new LogKey(this, "resetitemusetimestamp")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  457 */         new xdb.logs.LogLong(this, DoublePoint.this.resetitemusetimestamp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  461 */             DoublePoint.this.resetitemusetimestamp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  465 */     });
/*  466 */     this.resetitemusetimestamp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setItemusecount(int _v_)
/*      */   {
/*  473 */     _xdb_verify_unsafe_();
/*  474 */     Logs.logIf(new LogKey(this, "itemusecount")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  478 */         new LogInt(this, DoublePoint.this.itemusecount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  482 */             DoublePoint.this.itemusecount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  486 */     });
/*  487 */     this.itemusecount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  493 */     _xdb_verify_unsafe_();
/*  494 */     DoublePoint _o_ = null;
/*  495 */     if ((_o1_ instanceof DoublePoint)) { _o_ = (DoublePoint)_o1_;
/*  496 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  497 */       return false;
/*  498 */     if (this.gettingpoolpointnum != _o_.gettingpoolpointnum) return false;
/*  499 */     if (this.frozenpoolpointnum != _o_.frozenpoolpointnum) return false;
/*  500 */     if (this.offertimestamp != _o_.offertimestamp) return false;
/*  501 */     if (this.resetitemusetimestamp != _o_.resetitemusetimestamp) return false;
/*  502 */     if (this.itemusecount != _o_.itemusecount) return false;
/*  503 */     if (!this.switches.equals(_o_.switches)) return false;
/*  504 */     if (!this.switch_inits.equals(_o_.switch_inits)) return false;
/*  505 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  511 */     _xdb_verify_unsafe_();
/*  512 */     int _h_ = 0;
/*  513 */     _h_ += this.gettingpoolpointnum;
/*  514 */     _h_ += this.frozenpoolpointnum;
/*  515 */     _h_ = (int)(_h_ + this.offertimestamp);
/*  516 */     _h_ = (int)(_h_ + this.resetitemusetimestamp);
/*  517 */     _h_ += this.itemusecount;
/*  518 */     _h_ += this.switches.hashCode();
/*  519 */     _h_ += this.switch_inits.hashCode();
/*  520 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  526 */     _xdb_verify_unsafe_();
/*  527 */     StringBuilder _sb_ = new StringBuilder();
/*  528 */     _sb_.append("(");
/*  529 */     _sb_.append(this.gettingpoolpointnum);
/*  530 */     _sb_.append(",");
/*  531 */     _sb_.append(this.frozenpoolpointnum);
/*  532 */     _sb_.append(",");
/*  533 */     _sb_.append(this.offertimestamp);
/*  534 */     _sb_.append(",");
/*  535 */     _sb_.append(this.resetitemusetimestamp);
/*  536 */     _sb_.append(",");
/*  537 */     _sb_.append(this.itemusecount);
/*  538 */     _sb_.append(",");
/*  539 */     _sb_.append(this.switches);
/*  540 */     _sb_.append(",");
/*  541 */     _sb_.append(this.switch_inits);
/*  542 */     _sb_.append(")");
/*  543 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  549 */     ListenableBean lb = new ListenableBean();
/*  550 */     lb.add(new ListenableChanged().setVarName("gettingpoolpointnum"));
/*  551 */     lb.add(new ListenableChanged().setVarName("frozenpoolpointnum"));
/*  552 */     lb.add(new ListenableChanged().setVarName("offertimestamp"));
/*  553 */     lb.add(new ListenableChanged().setVarName("resetitemusetimestamp"));
/*  554 */     lb.add(new ListenableChanged().setVarName("itemusecount"));
/*  555 */     lb.add(new xdb.logs.ListenableSet().setVarName("switches"));
/*  556 */     lb.add(new xdb.logs.ListenableSet().setVarName("switch_inits"));
/*  557 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.DoublePoint {
/*      */     private Const() {}
/*      */     
/*      */     DoublePoint nThis() {
/*  564 */       return DoublePoint.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  570 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.DoublePoint copy()
/*      */     {
/*  576 */       return DoublePoint.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.DoublePoint toData()
/*      */     {
/*  582 */       return DoublePoint.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.DoublePoint toBean()
/*      */     {
/*  587 */       return DoublePoint.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.DoublePoint toDataIf()
/*      */     {
/*  593 */       return DoublePoint.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.DoublePoint toBeanIf()
/*      */     {
/*  598 */       return DoublePoint.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGettingpoolpointnum()
/*      */     {
/*  605 */       DoublePoint.this._xdb_verify_unsafe_();
/*  606 */       return DoublePoint.this.gettingpoolpointnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFrozenpoolpointnum()
/*      */     {
/*  613 */       DoublePoint.this._xdb_verify_unsafe_();
/*  614 */       return DoublePoint.this.frozenpoolpointnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getOffertimestamp()
/*      */     {
/*  621 */       DoublePoint.this._xdb_verify_unsafe_();
/*  622 */       return DoublePoint.this.offertimestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getResetitemusetimestamp()
/*      */     {
/*  629 */       DoublePoint.this._xdb_verify_unsafe_();
/*  630 */       return DoublePoint.this.resetitemusetimestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getItemusecount()
/*      */     {
/*  637 */       DoublePoint.this._xdb_verify_unsafe_();
/*  638 */       return DoublePoint.this.itemusecount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getSwitches()
/*      */     {
/*  645 */       DoublePoint.this._xdb_verify_unsafe_();
/*  646 */       return xdb.Consts.constSet(DoublePoint.this.switches);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Integer> getSwitchesAsData()
/*      */     {
/*  652 */       DoublePoint.this._xdb_verify_unsafe_();
/*      */       
/*  654 */       DoublePoint _o_ = DoublePoint.this;
/*  655 */       Set<Integer> switches = new SetX();
/*  656 */       switches.addAll(_o_.switches);
/*  657 */       return switches;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getSwitch_inits()
/*      */     {
/*  664 */       DoublePoint.this._xdb_verify_unsafe_();
/*  665 */       return xdb.Consts.constSet(DoublePoint.this.switch_inits);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Integer> getSwitch_initsAsData()
/*      */     {
/*  671 */       DoublePoint.this._xdb_verify_unsafe_();
/*      */       
/*  673 */       DoublePoint _o_ = DoublePoint.this;
/*  674 */       Set<Integer> switch_inits = new SetX();
/*  675 */       switch_inits.addAll(_o_.switch_inits);
/*  676 */       return switch_inits;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGettingpoolpointnum(int _v_)
/*      */     {
/*  683 */       DoublePoint.this._xdb_verify_unsafe_();
/*  684 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFrozenpoolpointnum(int _v_)
/*      */     {
/*  691 */       DoublePoint.this._xdb_verify_unsafe_();
/*  692 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOffertimestamp(long _v_)
/*      */     {
/*  699 */       DoublePoint.this._xdb_verify_unsafe_();
/*  700 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setResetitemusetimestamp(long _v_)
/*      */     {
/*  707 */       DoublePoint.this._xdb_verify_unsafe_();
/*  708 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setItemusecount(int _v_)
/*      */     {
/*  715 */       DoublePoint.this._xdb_verify_unsafe_();
/*  716 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  722 */       DoublePoint.this._xdb_verify_unsafe_();
/*  723 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  729 */       DoublePoint.this._xdb_verify_unsafe_();
/*  730 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  736 */       return DoublePoint.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  742 */       return DoublePoint.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  748 */       DoublePoint.this._xdb_verify_unsafe_();
/*  749 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  755 */       return DoublePoint.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  761 */       return DoublePoint.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  767 */       DoublePoint.this._xdb_verify_unsafe_();
/*  768 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  774 */       return DoublePoint.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  780 */       return DoublePoint.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  786 */       return DoublePoint.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  792 */       return DoublePoint.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  798 */       return DoublePoint.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  804 */       return DoublePoint.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  810 */       return DoublePoint.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.DoublePoint
/*      */   {
/*      */     private int gettingpoolpointnum;
/*      */     
/*      */     private int frozenpoolpointnum;
/*      */     
/*      */     private long offertimestamp;
/*      */     
/*      */     private long resetitemusetimestamp;
/*      */     
/*      */     private int itemusecount;
/*      */     
/*      */     private HashSet<Integer> switches;
/*      */     
/*      */     private HashSet<Integer> switch_inits;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  834 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  839 */       this.gettingpoolpointnum = 0;
/*  840 */       this.frozenpoolpointnum = 0;
/*  841 */       this.itemusecount = 0;
/*  842 */       this.switches = new HashSet();
/*  843 */       this.switch_inits = new HashSet();
/*      */     }
/*      */     
/*      */     Data(xbean.DoublePoint _o1_)
/*      */     {
/*  848 */       if ((_o1_ instanceof DoublePoint)) { assign((DoublePoint)_o1_);
/*  849 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  850 */       } else if ((_o1_ instanceof DoublePoint.Const)) assign(((DoublePoint.Const)_o1_).nThis()); else {
/*  851 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(DoublePoint _o_) {
/*  856 */       this.gettingpoolpointnum = _o_.gettingpoolpointnum;
/*  857 */       this.frozenpoolpointnum = _o_.frozenpoolpointnum;
/*  858 */       this.offertimestamp = _o_.offertimestamp;
/*  859 */       this.resetitemusetimestamp = _o_.resetitemusetimestamp;
/*  860 */       this.itemusecount = _o_.itemusecount;
/*  861 */       this.switches = new HashSet();
/*  862 */       this.switches.addAll(_o_.switches);
/*  863 */       this.switch_inits = new HashSet();
/*  864 */       this.switch_inits.addAll(_o_.switch_inits);
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  869 */       this.gettingpoolpointnum = _o_.gettingpoolpointnum;
/*  870 */       this.frozenpoolpointnum = _o_.frozenpoolpointnum;
/*  871 */       this.offertimestamp = _o_.offertimestamp;
/*  872 */       this.resetitemusetimestamp = _o_.resetitemusetimestamp;
/*  873 */       this.itemusecount = _o_.itemusecount;
/*  874 */       this.switches = new HashSet();
/*  875 */       this.switches.addAll(_o_.switches);
/*  876 */       this.switch_inits = new HashSet();
/*  877 */       this.switch_inits.addAll(_o_.switch_inits);
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  883 */       _os_.marshal(this.gettingpoolpointnum);
/*  884 */       _os_.marshal(this.frozenpoolpointnum);
/*  885 */       _os_.marshal(this.offertimestamp);
/*  886 */       _os_.marshal(this.resetitemusetimestamp);
/*  887 */       _os_.marshal(this.itemusecount);
/*  888 */       _os_.compact_uint32(this.switches.size());
/*  889 */       for (Integer _v_ : this.switches)
/*      */       {
/*  891 */         _os_.marshal(_v_.intValue());
/*      */       }
/*  893 */       _os_.compact_uint32(this.switch_inits.size());
/*  894 */       for (Integer _v_ : this.switch_inits)
/*      */       {
/*  896 */         _os_.marshal(_v_.intValue());
/*      */       }
/*  898 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  904 */       this.gettingpoolpointnum = _os_.unmarshal_int();
/*  905 */       this.frozenpoolpointnum = _os_.unmarshal_int();
/*  906 */       this.offertimestamp = _os_.unmarshal_long();
/*  907 */       this.resetitemusetimestamp = _os_.unmarshal_long();
/*  908 */       this.itemusecount = _os_.unmarshal_int();
/*  909 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  911 */         int _v_ = 0;
/*  912 */         _v_ = _os_.unmarshal_int();
/*  913 */         this.switches.add(Integer.valueOf(_v_));
/*      */       }
/*  915 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  917 */         int _v_ = 0;
/*  918 */         _v_ = _os_.unmarshal_int();
/*  919 */         this.switch_inits.add(Integer.valueOf(_v_));
/*      */       }
/*  921 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  927 */       int _size_ = 0;
/*  928 */       _size_ += CodedOutputStream.computeInt32Size(1, this.gettingpoolpointnum);
/*  929 */       _size_ += CodedOutputStream.computeInt32Size(2, this.frozenpoolpointnum);
/*  930 */       _size_ += CodedOutputStream.computeInt64Size(3, this.offertimestamp);
/*  931 */       _size_ += CodedOutputStream.computeInt64Size(4, this.resetitemusetimestamp);
/*  932 */       _size_ += CodedOutputStream.computeInt32Size(5, this.itemusecount);
/*  933 */       for (Integer _v_ : this.switches)
/*      */       {
/*  935 */         _size_ += CodedOutputStream.computeInt32Size(6, _v_.intValue());
/*      */       }
/*  937 */       for (Integer _v_ : this.switch_inits)
/*      */       {
/*  939 */         _size_ += CodedOutputStream.computeInt32Size(8, _v_.intValue());
/*      */       }
/*  941 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  949 */         _output_.writeInt32(1, this.gettingpoolpointnum);
/*  950 */         _output_.writeInt32(2, this.frozenpoolpointnum);
/*  951 */         _output_.writeInt64(3, this.offertimestamp);
/*  952 */         _output_.writeInt64(4, this.resetitemusetimestamp);
/*  953 */         _output_.writeInt32(5, this.itemusecount);
/*  954 */         for (Integer _v_ : this.switches)
/*      */         {
/*  956 */           _output_.writeInt32(6, _v_.intValue());
/*      */         }
/*  958 */         for (Integer _v_ : this.switch_inits)
/*      */         {
/*  960 */           _output_.writeInt32(8, _v_.intValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  965 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  967 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  975 */         boolean done = false;
/*  976 */         while (!done)
/*      */         {
/*  978 */           int tag = _input_.readTag();
/*  979 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  983 */             done = true;
/*  984 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  988 */             this.gettingpoolpointnum = _input_.readInt32();
/*  989 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  993 */             this.frozenpoolpointnum = _input_.readInt32();
/*  994 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  998 */             this.offertimestamp = _input_.readInt64();
/*  999 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1003 */             this.resetitemusetimestamp = _input_.readInt64();
/* 1004 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1008 */             this.itemusecount = _input_.readInt32();
/* 1009 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1013 */             int _v_ = 0;
/* 1014 */             _v_ = _input_.readInt32();
/* 1015 */             this.switches.add(Integer.valueOf(_v_));
/* 1016 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1020 */             int _v_ = 0;
/* 1021 */             _v_ = _input_.readInt32();
/* 1022 */             this.switch_inits.add(Integer.valueOf(_v_));
/* 1023 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1027 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1029 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1038 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1042 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1044 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.DoublePoint copy()
/*      */     {
/* 1050 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.DoublePoint toData()
/*      */     {
/* 1056 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.DoublePoint toBean()
/*      */     {
/* 1061 */       return new DoublePoint(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.DoublePoint toDataIf()
/*      */     {
/* 1067 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.DoublePoint toBeanIf()
/*      */     {
/* 1072 */       return new DoublePoint(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1078 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1082 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1086 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1090 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1094 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1098 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1102 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGettingpoolpointnum()
/*      */     {
/* 1109 */       return this.gettingpoolpointnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFrozenpoolpointnum()
/*      */     {
/* 1116 */       return this.frozenpoolpointnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getOffertimestamp()
/*      */     {
/* 1123 */       return this.offertimestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getResetitemusetimestamp()
/*      */     {
/* 1130 */       return this.resetitemusetimestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getItemusecount()
/*      */     {
/* 1137 */       return this.itemusecount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getSwitches()
/*      */     {
/* 1144 */       return this.switches;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getSwitchesAsData()
/*      */     {
/* 1151 */       return this.switches;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getSwitch_inits()
/*      */     {
/* 1158 */       return this.switch_inits;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getSwitch_initsAsData()
/*      */     {
/* 1165 */       return this.switch_inits;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGettingpoolpointnum(int _v_)
/*      */     {
/* 1172 */       this.gettingpoolpointnum = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFrozenpoolpointnum(int _v_)
/*      */     {
/* 1179 */       this.frozenpoolpointnum = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOffertimestamp(long _v_)
/*      */     {
/* 1186 */       this.offertimestamp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setResetitemusetimestamp(long _v_)
/*      */     {
/* 1193 */       this.resetitemusetimestamp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setItemusecount(int _v_)
/*      */     {
/* 1200 */       this.itemusecount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1206 */       if (!(_o1_ instanceof Data)) return false;
/* 1207 */       Data _o_ = (Data)_o1_;
/* 1208 */       if (this.gettingpoolpointnum != _o_.gettingpoolpointnum) return false;
/* 1209 */       if (this.frozenpoolpointnum != _o_.frozenpoolpointnum) return false;
/* 1210 */       if (this.offertimestamp != _o_.offertimestamp) return false;
/* 1211 */       if (this.resetitemusetimestamp != _o_.resetitemusetimestamp) return false;
/* 1212 */       if (this.itemusecount != _o_.itemusecount) return false;
/* 1213 */       if (!this.switches.equals(_o_.switches)) return false;
/* 1214 */       if (!this.switch_inits.equals(_o_.switch_inits)) return false;
/* 1215 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1221 */       int _h_ = 0;
/* 1222 */       _h_ += this.gettingpoolpointnum;
/* 1223 */       _h_ += this.frozenpoolpointnum;
/* 1224 */       _h_ = (int)(_h_ + this.offertimestamp);
/* 1225 */       _h_ = (int)(_h_ + this.resetitemusetimestamp);
/* 1226 */       _h_ += this.itemusecount;
/* 1227 */       _h_ += this.switches.hashCode();
/* 1228 */       _h_ += this.switch_inits.hashCode();
/* 1229 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1235 */       StringBuilder _sb_ = new StringBuilder();
/* 1236 */       _sb_.append("(");
/* 1237 */       _sb_.append(this.gettingpoolpointnum);
/* 1238 */       _sb_.append(",");
/* 1239 */       _sb_.append(this.frozenpoolpointnum);
/* 1240 */       _sb_.append(",");
/* 1241 */       _sb_.append(this.offertimestamp);
/* 1242 */       _sb_.append(",");
/* 1243 */       _sb_.append(this.resetitemusetimestamp);
/* 1244 */       _sb_.append(",");
/* 1245 */       _sb_.append(this.itemusecount);
/* 1246 */       _sb_.append(",");
/* 1247 */       _sb_.append(this.switches);
/* 1248 */       _sb_.append(",");
/* 1249 */       _sb_.append(this.switch_inits);
/* 1250 */       _sb_.append(")");
/* 1251 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\DoublePoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */