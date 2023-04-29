/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ 
/*      */ public final class WingInfo extends XBean implements xbean.WingInfo
/*      */ {
/*      */   private int exp;
/*      */   private int level;
/*      */   private int phase;
/*      */   private ArrayList<xbean.WingProperty> propertylist;
/*      */   private ArrayList<xbean.WingSkill> skilllist;
/*      */   private int curmodelid;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.exp = 0;
/*   29 */     this.level = 0;
/*   30 */     this.phase = 0;
/*   31 */     this.propertylist.clear();
/*   32 */     this.skilllist.clear();
/*   33 */     this.curmodelid = 0;
/*      */   }
/*      */   
/*      */   WingInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.exp = 0;
/*   40 */     this.level = 0;
/*   41 */     this.phase = 0;
/*   42 */     this.propertylist = new ArrayList();
/*   43 */     this.skilllist = new ArrayList();
/*   44 */     this.curmodelid = 0;
/*      */   }
/*      */   
/*      */   public WingInfo()
/*      */   {
/*   49 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public WingInfo(WingInfo _o_)
/*      */   {
/*   54 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   WingInfo(xbean.WingInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   59 */     super(_xp_, _vn_);
/*   60 */     if ((_o1_ instanceof WingInfo)) { assign((WingInfo)_o1_);
/*   61 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   62 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   63 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(WingInfo _o_) {
/*   68 */     _o_._xdb_verify_unsafe_();
/*   69 */     this.exp = _o_.exp;
/*   70 */     this.level = _o_.level;
/*   71 */     this.phase = _o_.phase;
/*   72 */     this.propertylist = new ArrayList();
/*   73 */     for (xbean.WingProperty _v_ : _o_.propertylist)
/*   74 */       this.propertylist.add(new WingProperty(_v_, this, "propertylist"));
/*   75 */     this.skilllist = new ArrayList();
/*   76 */     for (xbean.WingSkill _v_ : _o_.skilllist)
/*   77 */       this.skilllist.add(new WingSkill(_v_, this, "skilllist"));
/*   78 */     this.curmodelid = _o_.curmodelid;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   83 */     this.exp = _o_.exp;
/*   84 */     this.level = _o_.level;
/*   85 */     this.phase = _o_.phase;
/*   86 */     this.propertylist = new ArrayList();
/*   87 */     for (xbean.WingProperty _v_ : _o_.propertylist)
/*   88 */       this.propertylist.add(new WingProperty(_v_, this, "propertylist"));
/*   89 */     this.skilllist = new ArrayList();
/*   90 */     for (xbean.WingSkill _v_ : _o_.skilllist)
/*   91 */       this.skilllist.add(new WingSkill(_v_, this, "skilllist"));
/*   92 */     this.curmodelid = _o_.curmodelid;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   98 */     _xdb_verify_unsafe_();
/*   99 */     _os_.marshal(this.exp);
/*  100 */     _os_.marshal(this.level);
/*  101 */     _os_.marshal(this.phase);
/*  102 */     _os_.compact_uint32(this.propertylist.size());
/*  103 */     for (xbean.WingProperty _v_ : this.propertylist)
/*      */     {
/*  105 */       _v_.marshal(_os_);
/*      */     }
/*  107 */     _os_.compact_uint32(this.skilllist.size());
/*  108 */     for (xbean.WingSkill _v_ : this.skilllist)
/*      */     {
/*  110 */       _v_.marshal(_os_);
/*      */     }
/*  112 */     _os_.marshal(this.curmodelid);
/*  113 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  119 */     _xdb_verify_unsafe_();
/*  120 */     this.exp = _os_.unmarshal_int();
/*  121 */     this.level = _os_.unmarshal_int();
/*  122 */     this.phase = _os_.unmarshal_int();
/*  123 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  125 */       xbean.WingProperty _v_ = new WingProperty(0, this, "propertylist");
/*  126 */       _v_.unmarshal(_os_);
/*  127 */       this.propertylist.add(_v_);
/*      */     }
/*  129 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  131 */       xbean.WingSkill _v_ = new WingSkill(0, this, "skilllist");
/*  132 */       _v_.unmarshal(_os_);
/*  133 */       this.skilllist.add(_v_);
/*      */     }
/*  135 */     this.curmodelid = _os_.unmarshal_int();
/*  136 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  142 */     _xdb_verify_unsafe_();
/*  143 */     int _size_ = 0;
/*  144 */     _size_ += CodedOutputStream.computeInt32Size(1, this.exp);
/*  145 */     _size_ += CodedOutputStream.computeInt32Size(2, this.level);
/*  146 */     _size_ += CodedOutputStream.computeInt32Size(3, this.phase);
/*  147 */     for (xbean.WingProperty _v_ : this.propertylist)
/*      */     {
/*  149 */       _size_ += CodedOutputStream.computeMessageSize(4, _v_);
/*      */     }
/*  151 */     for (xbean.WingSkill _v_ : this.skilllist)
/*      */     {
/*  153 */       _size_ += CodedOutputStream.computeMessageSize(5, _v_);
/*      */     }
/*  155 */     _size_ += CodedOutputStream.computeInt32Size(6, this.curmodelid);
/*  156 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  162 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  165 */       _output_.writeInt32(1, this.exp);
/*  166 */       _output_.writeInt32(2, this.level);
/*  167 */       _output_.writeInt32(3, this.phase);
/*  168 */       for (xbean.WingProperty _v_ : this.propertylist)
/*      */       {
/*  170 */         _output_.writeMessage(4, _v_);
/*      */       }
/*  172 */       for (xbean.WingSkill _v_ : this.skilllist)
/*      */       {
/*  174 */         _output_.writeMessage(5, _v_);
/*      */       }
/*  176 */       _output_.writeInt32(6, this.curmodelid);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  180 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  182 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  188 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  191 */       boolean done = false;
/*  192 */       while (!done)
/*      */       {
/*  194 */         int tag = _input_.readTag();
/*  195 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  199 */           done = true;
/*  200 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  204 */           this.exp = _input_.readInt32();
/*  205 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  209 */           this.level = _input_.readInt32();
/*  210 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  214 */           this.phase = _input_.readInt32();
/*  215 */           break;
/*      */         
/*      */ 
/*      */         case 34: 
/*  219 */           xbean.WingProperty _v_ = new WingProperty(0, this, "propertylist");
/*  220 */           _input_.readMessage(_v_);
/*  221 */           this.propertylist.add(_v_);
/*  222 */           break;
/*      */         
/*      */ 
/*      */         case 42: 
/*  226 */           xbean.WingSkill _v_ = new WingSkill(0, this, "skilllist");
/*  227 */           _input_.readMessage(_v_);
/*  228 */           this.skilllist.add(_v_);
/*  229 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  233 */           this.curmodelid = _input_.readInt32();
/*  234 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  238 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  240 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  249 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  253 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  255 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.WingInfo copy()
/*      */   {
/*  261 */     _xdb_verify_unsafe_();
/*  262 */     return new WingInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.WingInfo toData()
/*      */   {
/*  268 */     _xdb_verify_unsafe_();
/*  269 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.WingInfo toBean()
/*      */   {
/*  274 */     _xdb_verify_unsafe_();
/*  275 */     return new WingInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.WingInfo toDataIf()
/*      */   {
/*  281 */     _xdb_verify_unsafe_();
/*  282 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.WingInfo toBeanIf()
/*      */   {
/*  287 */     _xdb_verify_unsafe_();
/*  288 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  294 */     _xdb_verify_unsafe_();
/*  295 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getExp()
/*      */   {
/*  302 */     _xdb_verify_unsafe_();
/*  303 */     return this.exp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getLevel()
/*      */   {
/*  310 */     _xdb_verify_unsafe_();
/*  311 */     return this.level;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPhase()
/*      */   {
/*  318 */     _xdb_verify_unsafe_();
/*  319 */     return this.phase;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<xbean.WingProperty> getPropertylist()
/*      */   {
/*  326 */     _xdb_verify_unsafe_();
/*  327 */     return Logs.logList(new LogKey(this, "propertylist"), this.propertylist);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<xbean.WingProperty> getPropertylistAsData()
/*      */   {
/*  333 */     _xdb_verify_unsafe_();
/*      */     
/*  335 */     WingInfo _o_ = this;
/*  336 */     List<xbean.WingProperty> propertylist = new ArrayList();
/*  337 */     for (xbean.WingProperty _v_ : _o_.propertylist)
/*  338 */       propertylist.add(new WingProperty.Data(_v_));
/*  339 */     return propertylist;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<xbean.WingSkill> getSkilllist()
/*      */   {
/*  346 */     _xdb_verify_unsafe_();
/*  347 */     return Logs.logList(new LogKey(this, "skilllist"), this.skilllist);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<xbean.WingSkill> getSkilllistAsData()
/*      */   {
/*  353 */     _xdb_verify_unsafe_();
/*      */     
/*  355 */     WingInfo _o_ = this;
/*  356 */     List<xbean.WingSkill> skilllist = new ArrayList();
/*  357 */     for (xbean.WingSkill _v_ : _o_.skilllist)
/*  358 */       skilllist.add(new WingSkill.Data(_v_));
/*  359 */     return skilllist;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCurmodelid()
/*      */   {
/*  366 */     _xdb_verify_unsafe_();
/*  367 */     return this.curmodelid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setExp(int _v_)
/*      */   {
/*  374 */     _xdb_verify_unsafe_();
/*  375 */     Logs.logIf(new LogKey(this, "exp")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  379 */         new LogInt(this, WingInfo.this.exp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  383 */             WingInfo.this.exp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  387 */     });
/*  388 */     this.exp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLevel(int _v_)
/*      */   {
/*  395 */     _xdb_verify_unsafe_();
/*  396 */     Logs.logIf(new LogKey(this, "level")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  400 */         new LogInt(this, WingInfo.this.level)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  404 */             WingInfo.this.level = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  408 */     });
/*  409 */     this.level = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPhase(int _v_)
/*      */   {
/*  416 */     _xdb_verify_unsafe_();
/*  417 */     Logs.logIf(new LogKey(this, "phase")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  421 */         new LogInt(this, WingInfo.this.phase)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  425 */             WingInfo.this.phase = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  429 */     });
/*  430 */     this.phase = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurmodelid(int _v_)
/*      */   {
/*  437 */     _xdb_verify_unsafe_();
/*  438 */     Logs.logIf(new LogKey(this, "curmodelid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  442 */         new LogInt(this, WingInfo.this.curmodelid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  446 */             WingInfo.this.curmodelid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  450 */     });
/*  451 */     this.curmodelid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  457 */     _xdb_verify_unsafe_();
/*  458 */     WingInfo _o_ = null;
/*  459 */     if ((_o1_ instanceof WingInfo)) { _o_ = (WingInfo)_o1_;
/*  460 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  461 */       return false;
/*  462 */     if (this.exp != _o_.exp) return false;
/*  463 */     if (this.level != _o_.level) return false;
/*  464 */     if (this.phase != _o_.phase) return false;
/*  465 */     if (!this.propertylist.equals(_o_.propertylist)) return false;
/*  466 */     if (!this.skilllist.equals(_o_.skilllist)) return false;
/*  467 */     if (this.curmodelid != _o_.curmodelid) return false;
/*  468 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  474 */     _xdb_verify_unsafe_();
/*  475 */     int _h_ = 0;
/*  476 */     _h_ += this.exp;
/*  477 */     _h_ += this.level;
/*  478 */     _h_ += this.phase;
/*  479 */     _h_ += this.propertylist.hashCode();
/*  480 */     _h_ += this.skilllist.hashCode();
/*  481 */     _h_ += this.curmodelid;
/*  482 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  488 */     _xdb_verify_unsafe_();
/*  489 */     StringBuilder _sb_ = new StringBuilder();
/*  490 */     _sb_.append("(");
/*  491 */     _sb_.append(this.exp);
/*  492 */     _sb_.append(",");
/*  493 */     _sb_.append(this.level);
/*  494 */     _sb_.append(",");
/*  495 */     _sb_.append(this.phase);
/*  496 */     _sb_.append(",");
/*  497 */     _sb_.append(this.propertylist);
/*  498 */     _sb_.append(",");
/*  499 */     _sb_.append(this.skilllist);
/*  500 */     _sb_.append(",");
/*  501 */     _sb_.append(this.curmodelid);
/*  502 */     _sb_.append(")");
/*  503 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  509 */     ListenableBean lb = new ListenableBean();
/*  510 */     lb.add(new ListenableChanged().setVarName("exp"));
/*  511 */     lb.add(new ListenableChanged().setVarName("level"));
/*  512 */     lb.add(new ListenableChanged().setVarName("phase"));
/*  513 */     lb.add(new ListenableChanged().setVarName("propertylist"));
/*  514 */     lb.add(new ListenableChanged().setVarName("skilllist"));
/*  515 */     lb.add(new ListenableChanged().setVarName("curmodelid"));
/*  516 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.WingInfo {
/*      */     private Const() {}
/*      */     
/*      */     WingInfo nThis() {
/*  523 */       return WingInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  529 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.WingInfo copy()
/*      */     {
/*  535 */       return WingInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.WingInfo toData()
/*      */     {
/*  541 */       return WingInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.WingInfo toBean()
/*      */     {
/*  546 */       return WingInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.WingInfo toDataIf()
/*      */     {
/*  552 */       return WingInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.WingInfo toBeanIf()
/*      */     {
/*  557 */       return WingInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getExp()
/*      */     {
/*  564 */       WingInfo.this._xdb_verify_unsafe_();
/*  565 */       return WingInfo.this.exp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLevel()
/*      */     {
/*  572 */       WingInfo.this._xdb_verify_unsafe_();
/*  573 */       return WingInfo.this.level;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPhase()
/*      */     {
/*  580 */       WingInfo.this._xdb_verify_unsafe_();
/*  581 */       return WingInfo.this.phase;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.WingProperty> getPropertylist()
/*      */     {
/*  588 */       WingInfo.this._xdb_verify_unsafe_();
/*  589 */       return xdb.Consts.constList(WingInfo.this.propertylist);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<xbean.WingProperty> getPropertylistAsData()
/*      */     {
/*  595 */       WingInfo.this._xdb_verify_unsafe_();
/*      */       
/*  597 */       WingInfo _o_ = WingInfo.this;
/*  598 */       List<xbean.WingProperty> propertylist = new ArrayList();
/*  599 */       for (xbean.WingProperty _v_ : _o_.propertylist)
/*  600 */         propertylist.add(new WingProperty.Data(_v_));
/*  601 */       return propertylist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.WingSkill> getSkilllist()
/*      */     {
/*  608 */       WingInfo.this._xdb_verify_unsafe_();
/*  609 */       return xdb.Consts.constList(WingInfo.this.skilllist);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<xbean.WingSkill> getSkilllistAsData()
/*      */     {
/*  615 */       WingInfo.this._xdb_verify_unsafe_();
/*      */       
/*  617 */       WingInfo _o_ = WingInfo.this;
/*  618 */       List<xbean.WingSkill> skilllist = new ArrayList();
/*  619 */       for (xbean.WingSkill _v_ : _o_.skilllist)
/*  620 */         skilllist.add(new WingSkill.Data(_v_));
/*  621 */       return skilllist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurmodelid()
/*      */     {
/*  628 */       WingInfo.this._xdb_verify_unsafe_();
/*  629 */       return WingInfo.this.curmodelid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setExp(int _v_)
/*      */     {
/*  636 */       WingInfo.this._xdb_verify_unsafe_();
/*  637 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLevel(int _v_)
/*      */     {
/*  644 */       WingInfo.this._xdb_verify_unsafe_();
/*  645 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPhase(int _v_)
/*      */     {
/*  652 */       WingInfo.this._xdb_verify_unsafe_();
/*  653 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurmodelid(int _v_)
/*      */     {
/*  660 */       WingInfo.this._xdb_verify_unsafe_();
/*  661 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  667 */       WingInfo.this._xdb_verify_unsafe_();
/*  668 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  674 */       WingInfo.this._xdb_verify_unsafe_();
/*  675 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  681 */       return WingInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  687 */       return WingInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  693 */       WingInfo.this._xdb_verify_unsafe_();
/*  694 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  700 */       return WingInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  706 */       return WingInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  712 */       WingInfo.this._xdb_verify_unsafe_();
/*  713 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  719 */       return WingInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  725 */       return WingInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  731 */       return WingInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  737 */       return WingInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  743 */       return WingInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  749 */       return WingInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  755 */       return WingInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.WingInfo
/*      */   {
/*      */     private int exp;
/*      */     
/*      */     private int level;
/*      */     
/*      */     private int phase;
/*      */     
/*      */     private ArrayList<xbean.WingProperty> propertylist;
/*      */     
/*      */     private ArrayList<xbean.WingSkill> skilllist;
/*      */     
/*      */     private int curmodelid;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  777 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  782 */       this.exp = 0;
/*  783 */       this.level = 0;
/*  784 */       this.phase = 0;
/*  785 */       this.propertylist = new ArrayList();
/*  786 */       this.skilllist = new ArrayList();
/*  787 */       this.curmodelid = 0;
/*      */     }
/*      */     
/*      */     Data(xbean.WingInfo _o1_)
/*      */     {
/*  792 */       if ((_o1_ instanceof WingInfo)) { assign((WingInfo)_o1_);
/*  793 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  794 */       } else if ((_o1_ instanceof WingInfo.Const)) assign(((WingInfo.Const)_o1_).nThis()); else {
/*  795 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(WingInfo _o_) {
/*  800 */       this.exp = _o_.exp;
/*  801 */       this.level = _o_.level;
/*  802 */       this.phase = _o_.phase;
/*  803 */       this.propertylist = new ArrayList();
/*  804 */       for (xbean.WingProperty _v_ : _o_.propertylist)
/*  805 */         this.propertylist.add(new WingProperty.Data(_v_));
/*  806 */       this.skilllist = new ArrayList();
/*  807 */       for (xbean.WingSkill _v_ : _o_.skilllist)
/*  808 */         this.skilllist.add(new WingSkill.Data(_v_));
/*  809 */       this.curmodelid = _o_.curmodelid;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  814 */       this.exp = _o_.exp;
/*  815 */       this.level = _o_.level;
/*  816 */       this.phase = _o_.phase;
/*  817 */       this.propertylist = new ArrayList();
/*  818 */       for (xbean.WingProperty _v_ : _o_.propertylist)
/*  819 */         this.propertylist.add(new WingProperty.Data(_v_));
/*  820 */       this.skilllist = new ArrayList();
/*  821 */       for (xbean.WingSkill _v_ : _o_.skilllist)
/*  822 */         this.skilllist.add(new WingSkill.Data(_v_));
/*  823 */       this.curmodelid = _o_.curmodelid;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  829 */       _os_.marshal(this.exp);
/*  830 */       _os_.marshal(this.level);
/*  831 */       _os_.marshal(this.phase);
/*  832 */       _os_.compact_uint32(this.propertylist.size());
/*  833 */       for (xbean.WingProperty _v_ : this.propertylist)
/*      */       {
/*  835 */         _v_.marshal(_os_);
/*      */       }
/*  837 */       _os_.compact_uint32(this.skilllist.size());
/*  838 */       for (xbean.WingSkill _v_ : this.skilllist)
/*      */       {
/*  840 */         _v_.marshal(_os_);
/*      */       }
/*  842 */       _os_.marshal(this.curmodelid);
/*  843 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  849 */       this.exp = _os_.unmarshal_int();
/*  850 */       this.level = _os_.unmarshal_int();
/*  851 */       this.phase = _os_.unmarshal_int();
/*  852 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  854 */         xbean.WingProperty _v_ = xbean.Pod.newWingPropertyData();
/*  855 */         _v_.unmarshal(_os_);
/*  856 */         this.propertylist.add(_v_);
/*      */       }
/*  858 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  860 */         xbean.WingSkill _v_ = xbean.Pod.newWingSkillData();
/*  861 */         _v_.unmarshal(_os_);
/*  862 */         this.skilllist.add(_v_);
/*      */       }
/*  864 */       this.curmodelid = _os_.unmarshal_int();
/*  865 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  871 */       int _size_ = 0;
/*  872 */       _size_ += CodedOutputStream.computeInt32Size(1, this.exp);
/*  873 */       _size_ += CodedOutputStream.computeInt32Size(2, this.level);
/*  874 */       _size_ += CodedOutputStream.computeInt32Size(3, this.phase);
/*  875 */       for (xbean.WingProperty _v_ : this.propertylist)
/*      */       {
/*  877 */         _size_ += CodedOutputStream.computeMessageSize(4, _v_);
/*      */       }
/*  879 */       for (xbean.WingSkill _v_ : this.skilllist)
/*      */       {
/*  881 */         _size_ += CodedOutputStream.computeMessageSize(5, _v_);
/*      */       }
/*  883 */       _size_ += CodedOutputStream.computeInt32Size(6, this.curmodelid);
/*  884 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  892 */         _output_.writeInt32(1, this.exp);
/*  893 */         _output_.writeInt32(2, this.level);
/*  894 */         _output_.writeInt32(3, this.phase);
/*  895 */         for (xbean.WingProperty _v_ : this.propertylist)
/*      */         {
/*  897 */           _output_.writeMessage(4, _v_);
/*      */         }
/*  899 */         for (xbean.WingSkill _v_ : this.skilllist)
/*      */         {
/*  901 */           _output_.writeMessage(5, _v_);
/*      */         }
/*  903 */         _output_.writeInt32(6, this.curmodelid);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  907 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  909 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  917 */         boolean done = false;
/*  918 */         while (!done)
/*      */         {
/*  920 */           int tag = _input_.readTag();
/*  921 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  925 */             done = true;
/*  926 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  930 */             this.exp = _input_.readInt32();
/*  931 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  935 */             this.level = _input_.readInt32();
/*  936 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  940 */             this.phase = _input_.readInt32();
/*  941 */             break;
/*      */           
/*      */ 
/*      */           case 34: 
/*  945 */             xbean.WingProperty _v_ = xbean.Pod.newWingPropertyData();
/*  946 */             _input_.readMessage(_v_);
/*  947 */             this.propertylist.add(_v_);
/*  948 */             break;
/*      */           
/*      */ 
/*      */           case 42: 
/*  952 */             xbean.WingSkill _v_ = xbean.Pod.newWingSkillData();
/*  953 */             _input_.readMessage(_v_);
/*  954 */             this.skilllist.add(_v_);
/*  955 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  959 */             this.curmodelid = _input_.readInt32();
/*  960 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  964 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  966 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  975 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  979 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  981 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.WingInfo copy()
/*      */     {
/*  987 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.WingInfo toData()
/*      */     {
/*  993 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.WingInfo toBean()
/*      */     {
/*  998 */       return new WingInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.WingInfo toDataIf()
/*      */     {
/* 1004 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.WingInfo toBeanIf()
/*      */     {
/* 1009 */       return new WingInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1015 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1019 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1023 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1027 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1031 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1035 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1039 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getExp()
/*      */     {
/* 1046 */       return this.exp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLevel()
/*      */     {
/* 1053 */       return this.level;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPhase()
/*      */     {
/* 1060 */       return this.phase;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.WingProperty> getPropertylist()
/*      */     {
/* 1067 */       return this.propertylist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.WingProperty> getPropertylistAsData()
/*      */     {
/* 1074 */       return this.propertylist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.WingSkill> getSkilllist()
/*      */     {
/* 1081 */       return this.skilllist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.WingSkill> getSkilllistAsData()
/*      */     {
/* 1088 */       return this.skilllist;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurmodelid()
/*      */     {
/* 1095 */       return this.curmodelid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setExp(int _v_)
/*      */     {
/* 1102 */       this.exp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLevel(int _v_)
/*      */     {
/* 1109 */       this.level = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPhase(int _v_)
/*      */     {
/* 1116 */       this.phase = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurmodelid(int _v_)
/*      */     {
/* 1123 */       this.curmodelid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1129 */       if (!(_o1_ instanceof Data)) return false;
/* 1130 */       Data _o_ = (Data)_o1_;
/* 1131 */       if (this.exp != _o_.exp) return false;
/* 1132 */       if (this.level != _o_.level) return false;
/* 1133 */       if (this.phase != _o_.phase) return false;
/* 1134 */       if (!this.propertylist.equals(_o_.propertylist)) return false;
/* 1135 */       if (!this.skilllist.equals(_o_.skilllist)) return false;
/* 1136 */       if (this.curmodelid != _o_.curmodelid) return false;
/* 1137 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1143 */       int _h_ = 0;
/* 1144 */       _h_ += this.exp;
/* 1145 */       _h_ += this.level;
/* 1146 */       _h_ += this.phase;
/* 1147 */       _h_ += this.propertylist.hashCode();
/* 1148 */       _h_ += this.skilllist.hashCode();
/* 1149 */       _h_ += this.curmodelid;
/* 1150 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1156 */       StringBuilder _sb_ = new StringBuilder();
/* 1157 */       _sb_.append("(");
/* 1158 */       _sb_.append(this.exp);
/* 1159 */       _sb_.append(",");
/* 1160 */       _sb_.append(this.level);
/* 1161 */       _sb_.append(",");
/* 1162 */       _sb_.append(this.phase);
/* 1163 */       _sb_.append(",");
/* 1164 */       _sb_.append(this.propertylist);
/* 1165 */       _sb_.append(",");
/* 1166 */       _sb_.append(this.skilllist);
/* 1167 */       _sb_.append(",");
/* 1168 */       _sb_.append(this.curmodelid);
/* 1169 */       _sb_.append(")");
/* 1170 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\WingInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */