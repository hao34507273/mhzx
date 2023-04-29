/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.io.IOException;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ 
/*      */ public final class FriendInfo extends XBean implements xbean.FriendInfo
/*      */ {
/*      */   private int relationvalue;
/*      */   private HashMap<Integer, Integer> valuelimitmap;
/*      */   private HashMap<Integer, Integer> valuelimittotalmap;
/*      */   private long befriendtime;
/*      */   private String remarkname;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   26 */     this.relationvalue = 0;
/*   27 */     this.valuelimitmap.clear();
/*   28 */     this.valuelimittotalmap.clear();
/*   29 */     this.befriendtime = 0L;
/*   30 */     this.remarkname = "";
/*      */   }
/*      */   
/*      */   FriendInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   35 */     super(_xp_, _vn_);
/*   36 */     this.valuelimitmap = new HashMap();
/*   37 */     this.valuelimittotalmap = new HashMap();
/*   38 */     this.remarkname = "";
/*      */   }
/*      */   
/*      */   public FriendInfo()
/*      */   {
/*   43 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public FriendInfo(FriendInfo _o_)
/*      */   {
/*   48 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   FriendInfo(xbean.FriendInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   53 */     super(_xp_, _vn_);
/*   54 */     if ((_o1_ instanceof FriendInfo)) { assign((FriendInfo)_o1_);
/*   55 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   56 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   57 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(FriendInfo _o_) {
/*   62 */     _o_._xdb_verify_unsafe_();
/*   63 */     this.relationvalue = _o_.relationvalue;
/*   64 */     this.valuelimitmap = new HashMap();
/*   65 */     for (Map.Entry<Integer, Integer> _e_ : _o_.valuelimitmap.entrySet())
/*   66 */       this.valuelimitmap.put(_e_.getKey(), _e_.getValue());
/*   67 */     this.valuelimittotalmap = new HashMap();
/*   68 */     for (Map.Entry<Integer, Integer> _e_ : _o_.valuelimittotalmap.entrySet())
/*   69 */       this.valuelimittotalmap.put(_e_.getKey(), _e_.getValue());
/*   70 */     this.befriendtime = _o_.befriendtime;
/*   71 */     this.remarkname = _o_.remarkname;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   76 */     this.relationvalue = _o_.relationvalue;
/*   77 */     this.valuelimitmap = new HashMap();
/*   78 */     for (Map.Entry<Integer, Integer> _e_ : _o_.valuelimitmap.entrySet())
/*   79 */       this.valuelimitmap.put(_e_.getKey(), _e_.getValue());
/*   80 */     this.valuelimittotalmap = new HashMap();
/*   81 */     for (Map.Entry<Integer, Integer> _e_ : _o_.valuelimittotalmap.entrySet())
/*   82 */       this.valuelimittotalmap.put(_e_.getKey(), _e_.getValue());
/*   83 */     this.befriendtime = _o_.befriendtime;
/*   84 */     this.remarkname = _o_.remarkname;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   90 */     _xdb_verify_unsafe_();
/*   91 */     _os_.marshal(this.relationvalue);
/*   92 */     _os_.compact_uint32(this.valuelimitmap.size());
/*   93 */     for (Map.Entry<Integer, Integer> _e_ : this.valuelimitmap.entrySet())
/*      */     {
/*   95 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*   96 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*   98 */     _os_.compact_uint32(this.valuelimittotalmap.size());
/*   99 */     for (Map.Entry<Integer, Integer> _e_ : this.valuelimittotalmap.entrySet())
/*      */     {
/*  101 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  102 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  104 */     _os_.marshal(this.befriendtime);
/*  105 */     _os_.marshal(this.remarkname, "UTF-16LE");
/*  106 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  112 */     _xdb_verify_unsafe_();
/*  113 */     this.relationvalue = _os_.unmarshal_int();
/*      */     
/*  115 */     int size = _os_.uncompact_uint32();
/*  116 */     if (size >= 12)
/*      */     {
/*  118 */       this.valuelimitmap = new HashMap(size * 2);
/*      */     }
/*  120 */     for (; size > 0; size--)
/*      */     {
/*  122 */       int _k_ = 0;
/*  123 */       _k_ = _os_.unmarshal_int();
/*  124 */       int _v_ = 0;
/*  125 */       _v_ = _os_.unmarshal_int();
/*  126 */       this.valuelimitmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*      */ 
/*  130 */     int size = _os_.uncompact_uint32();
/*  131 */     if (size >= 12)
/*      */     {
/*  133 */       this.valuelimittotalmap = new HashMap(size * 2);
/*      */     }
/*  135 */     for (; size > 0; size--)
/*      */     {
/*  137 */       int _k_ = 0;
/*  138 */       _k_ = _os_.unmarshal_int();
/*  139 */       int _v_ = 0;
/*  140 */       _v_ = _os_.unmarshal_int();
/*  141 */       this.valuelimittotalmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  144 */     this.befriendtime = _os_.unmarshal_long();
/*  145 */     this.remarkname = _os_.unmarshal_String("UTF-16LE");
/*  146 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  152 */     _xdb_verify_unsafe_();
/*  153 */     int _size_ = 0;
/*  154 */     _size_ += CodedOutputStream.computeInt32Size(1, this.relationvalue);
/*  155 */     for (Map.Entry<Integer, Integer> _e_ : this.valuelimitmap.entrySet())
/*      */     {
/*  157 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/*  158 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  160 */     for (Map.Entry<Integer, Integer> _e_ : this.valuelimittotalmap.entrySet())
/*      */     {
/*  162 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/*  163 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  165 */     _size_ += CodedOutputStream.computeInt64Size(4, this.befriendtime);
/*      */     try
/*      */     {
/*  168 */       _size_ += CodedOutputStream.computeBytesSize(5, ppbio.ByteString.copyFrom(this.remarkname, "UTF-16LE"));
/*      */     }
/*      */     catch (java.io.UnsupportedEncodingException e)
/*      */     {
/*  172 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  174 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  180 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  183 */       _output_.writeInt32(1, this.relationvalue);
/*  184 */       for (Map.Entry<Integer, Integer> _e_ : this.valuelimitmap.entrySet())
/*      */       {
/*  186 */         _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/*  187 */         _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  189 */       for (Map.Entry<Integer, Integer> _e_ : this.valuelimittotalmap.entrySet())
/*      */       {
/*  191 */         _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/*  192 */         _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  194 */       _output_.writeInt64(4, this.befriendtime);
/*  195 */       _output_.writeBytes(5, ppbio.ByteString.copyFrom(this.remarkname, "UTF-16LE"));
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  199 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  201 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  207 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  210 */       boolean done = false;
/*  211 */       while (!done)
/*      */       {
/*  213 */         int tag = _input_.readTag();
/*  214 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  218 */           done = true;
/*  219 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  223 */           this.relationvalue = _input_.readInt32();
/*  224 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  228 */           int _k_ = 0;
/*  229 */           _k_ = _input_.readInt32();
/*  230 */           int readTag = _input_.readTag();
/*  231 */           if (16 != readTag)
/*      */           {
/*  233 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  235 */           int _v_ = 0;
/*  236 */           _v_ = _input_.readInt32();
/*  237 */           this.valuelimitmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  238 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  242 */           int _k_ = 0;
/*  243 */           _k_ = _input_.readInt32();
/*  244 */           int readTag = _input_.readTag();
/*  245 */           if (24 != readTag)
/*      */           {
/*  247 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  249 */           int _v_ = 0;
/*  250 */           _v_ = _input_.readInt32();
/*  251 */           this.valuelimittotalmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  252 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  256 */           this.befriendtime = _input_.readInt64();
/*  257 */           break;
/*      */         
/*      */ 
/*      */         case 42: 
/*  261 */           this.remarkname = _input_.readBytes().toString("UTF-16LE");
/*  262 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  266 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  268 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  277 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  281 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  283 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FriendInfo copy()
/*      */   {
/*  289 */     _xdb_verify_unsafe_();
/*  290 */     return new FriendInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FriendInfo toData()
/*      */   {
/*  296 */     _xdb_verify_unsafe_();
/*  297 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.FriendInfo toBean()
/*      */   {
/*  302 */     _xdb_verify_unsafe_();
/*  303 */     return new FriendInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FriendInfo toDataIf()
/*      */   {
/*  309 */     _xdb_verify_unsafe_();
/*  310 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.FriendInfo toBeanIf()
/*      */   {
/*  315 */     _xdb_verify_unsafe_();
/*  316 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  322 */     _xdb_verify_unsafe_();
/*  323 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getRelationvalue()
/*      */   {
/*  330 */     _xdb_verify_unsafe_();
/*  331 */     return this.relationvalue;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getValuelimitmap()
/*      */   {
/*  338 */     _xdb_verify_unsafe_();
/*  339 */     return xdb.Logs.logMap(new LogKey(this, "valuelimitmap"), this.valuelimitmap);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getValuelimitmapAsData()
/*      */   {
/*  346 */     _xdb_verify_unsafe_();
/*      */     
/*  348 */     FriendInfo _o_ = this;
/*  349 */     Map<Integer, Integer> valuelimitmap = new HashMap();
/*  350 */     for (Map.Entry<Integer, Integer> _e_ : _o_.valuelimitmap.entrySet())
/*  351 */       valuelimitmap.put(_e_.getKey(), _e_.getValue());
/*  352 */     return valuelimitmap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getValuelimittotalmap()
/*      */   {
/*  359 */     _xdb_verify_unsafe_();
/*  360 */     return xdb.Logs.logMap(new LogKey(this, "valuelimittotalmap"), this.valuelimittotalmap);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getValuelimittotalmapAsData()
/*      */   {
/*  367 */     _xdb_verify_unsafe_();
/*      */     
/*  369 */     FriendInfo _o_ = this;
/*  370 */     Map<Integer, Integer> valuelimittotalmap = new HashMap();
/*  371 */     for (Map.Entry<Integer, Integer> _e_ : _o_.valuelimittotalmap.entrySet())
/*  372 */       valuelimittotalmap.put(_e_.getKey(), _e_.getValue());
/*  373 */     return valuelimittotalmap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getBefriendtime()
/*      */   {
/*  380 */     _xdb_verify_unsafe_();
/*  381 */     return this.befriendtime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getRemarkname()
/*      */   {
/*  388 */     _xdb_verify_unsafe_();
/*  389 */     return this.remarkname;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getRemarknameOctets()
/*      */   {
/*  396 */     _xdb_verify_unsafe_();
/*  397 */     return Octets.wrap(getRemarkname(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRelationvalue(int _v_)
/*      */   {
/*  404 */     _xdb_verify_unsafe_();
/*  405 */     xdb.Logs.logIf(new LogKey(this, "relationvalue")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  409 */         new xdb.logs.LogInt(this, FriendInfo.this.relationvalue)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  413 */             FriendInfo.this.relationvalue = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  417 */     });
/*  418 */     this.relationvalue = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBefriendtime(long _v_)
/*      */   {
/*  425 */     _xdb_verify_unsafe_();
/*  426 */     xdb.Logs.logIf(new LogKey(this, "befriendtime")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  430 */         new xdb.logs.LogLong(this, FriendInfo.this.befriendtime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  434 */             FriendInfo.this.befriendtime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  438 */     });
/*  439 */     this.befriendtime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRemarkname(String _v_)
/*      */   {
/*  446 */     _xdb_verify_unsafe_();
/*  447 */     if (null == _v_)
/*  448 */       throw new NullPointerException();
/*  449 */     xdb.Logs.logIf(new LogKey(this, "remarkname")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  453 */         new xdb.logs.LogString(this, FriendInfo.this.remarkname)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  457 */             FriendInfo.this.remarkname = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  461 */     });
/*  462 */     this.remarkname = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRemarknameOctets(Octets _v_)
/*      */   {
/*  469 */     _xdb_verify_unsafe_();
/*  470 */     setRemarkname(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  476 */     _xdb_verify_unsafe_();
/*  477 */     FriendInfo _o_ = null;
/*  478 */     if ((_o1_ instanceof FriendInfo)) { _o_ = (FriendInfo)_o1_;
/*  479 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  480 */       return false;
/*  481 */     if (this.relationvalue != _o_.relationvalue) return false;
/*  482 */     if (!this.valuelimitmap.equals(_o_.valuelimitmap)) return false;
/*  483 */     if (!this.valuelimittotalmap.equals(_o_.valuelimittotalmap)) return false;
/*  484 */     if (this.befriendtime != _o_.befriendtime) return false;
/*  485 */     if (!this.remarkname.equals(_o_.remarkname)) return false;
/*  486 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  492 */     _xdb_verify_unsafe_();
/*  493 */     int _h_ = 0;
/*  494 */     _h_ += this.relationvalue;
/*  495 */     _h_ += this.valuelimitmap.hashCode();
/*  496 */     _h_ += this.valuelimittotalmap.hashCode();
/*  497 */     _h_ = (int)(_h_ + this.befriendtime);
/*  498 */     _h_ += this.remarkname.hashCode();
/*  499 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  505 */     _xdb_verify_unsafe_();
/*  506 */     StringBuilder _sb_ = new StringBuilder();
/*  507 */     _sb_.append("(");
/*  508 */     _sb_.append(this.relationvalue);
/*  509 */     _sb_.append(",");
/*  510 */     _sb_.append(this.valuelimitmap);
/*  511 */     _sb_.append(",");
/*  512 */     _sb_.append(this.valuelimittotalmap);
/*  513 */     _sb_.append(",");
/*  514 */     _sb_.append(this.befriendtime);
/*  515 */     _sb_.append(",");
/*  516 */     _sb_.append("'").append(this.remarkname).append("'");
/*  517 */     _sb_.append(")");
/*  518 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  524 */     ListenableBean lb = new ListenableBean();
/*  525 */     lb.add(new xdb.logs.ListenableChanged().setVarName("relationvalue"));
/*  526 */     lb.add(new xdb.logs.ListenableMap().setVarName("valuelimitmap"));
/*  527 */     lb.add(new xdb.logs.ListenableMap().setVarName("valuelimittotalmap"));
/*  528 */     lb.add(new xdb.logs.ListenableChanged().setVarName("befriendtime"));
/*  529 */     lb.add(new xdb.logs.ListenableChanged().setVarName("remarkname"));
/*  530 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.FriendInfo {
/*      */     private Const() {}
/*      */     
/*      */     FriendInfo nThis() {
/*  537 */       return FriendInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  543 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FriendInfo copy()
/*      */     {
/*  549 */       return FriendInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FriendInfo toData()
/*      */     {
/*  555 */       return FriendInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.FriendInfo toBean()
/*      */     {
/*  560 */       return FriendInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FriendInfo toDataIf()
/*      */     {
/*  566 */       return FriendInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.FriendInfo toBeanIf()
/*      */     {
/*  571 */       return FriendInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRelationvalue()
/*      */     {
/*  578 */       FriendInfo.this._xdb_verify_unsafe_();
/*  579 */       return FriendInfo.this.relationvalue;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getValuelimitmap()
/*      */     {
/*  586 */       FriendInfo.this._xdb_verify_unsafe_();
/*  587 */       return xdb.Consts.constMap(FriendInfo.this.valuelimitmap);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getValuelimitmapAsData()
/*      */     {
/*  594 */       FriendInfo.this._xdb_verify_unsafe_();
/*      */       
/*  596 */       FriendInfo _o_ = FriendInfo.this;
/*  597 */       Map<Integer, Integer> valuelimitmap = new HashMap();
/*  598 */       for (Map.Entry<Integer, Integer> _e_ : _o_.valuelimitmap.entrySet())
/*  599 */         valuelimitmap.put(_e_.getKey(), _e_.getValue());
/*  600 */       return valuelimitmap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getValuelimittotalmap()
/*      */     {
/*  607 */       FriendInfo.this._xdb_verify_unsafe_();
/*  608 */       return xdb.Consts.constMap(FriendInfo.this.valuelimittotalmap);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getValuelimittotalmapAsData()
/*      */     {
/*  615 */       FriendInfo.this._xdb_verify_unsafe_();
/*      */       
/*  617 */       FriendInfo _o_ = FriendInfo.this;
/*  618 */       Map<Integer, Integer> valuelimittotalmap = new HashMap();
/*  619 */       for (Map.Entry<Integer, Integer> _e_ : _o_.valuelimittotalmap.entrySet())
/*  620 */         valuelimittotalmap.put(_e_.getKey(), _e_.getValue());
/*  621 */       return valuelimittotalmap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBefriendtime()
/*      */     {
/*  628 */       FriendInfo.this._xdb_verify_unsafe_();
/*  629 */       return FriendInfo.this.befriendtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getRemarkname()
/*      */     {
/*  636 */       FriendInfo.this._xdb_verify_unsafe_();
/*  637 */       return FriendInfo.this.remarkname;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getRemarknameOctets()
/*      */     {
/*  644 */       FriendInfo.this._xdb_verify_unsafe_();
/*  645 */       return FriendInfo.this.getRemarknameOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRelationvalue(int _v_)
/*      */     {
/*  652 */       FriendInfo.this._xdb_verify_unsafe_();
/*  653 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBefriendtime(long _v_)
/*      */     {
/*  660 */       FriendInfo.this._xdb_verify_unsafe_();
/*  661 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRemarkname(String _v_)
/*      */     {
/*  668 */       FriendInfo.this._xdb_verify_unsafe_();
/*  669 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRemarknameOctets(Octets _v_)
/*      */     {
/*  676 */       FriendInfo.this._xdb_verify_unsafe_();
/*  677 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  683 */       FriendInfo.this._xdb_verify_unsafe_();
/*  684 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  690 */       FriendInfo.this._xdb_verify_unsafe_();
/*  691 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  697 */       return FriendInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  703 */       return FriendInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  709 */       FriendInfo.this._xdb_verify_unsafe_();
/*  710 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  716 */       return FriendInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  722 */       return FriendInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  728 */       FriendInfo.this._xdb_verify_unsafe_();
/*  729 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  735 */       return FriendInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  741 */       return FriendInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  747 */       return FriendInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  753 */       return FriendInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  759 */       return FriendInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  765 */       return FriendInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  771 */       return FriendInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.FriendInfo
/*      */   {
/*      */     private int relationvalue;
/*      */     
/*      */     private HashMap<Integer, Integer> valuelimitmap;
/*      */     
/*      */     private HashMap<Integer, Integer> valuelimittotalmap;
/*      */     
/*      */     private long befriendtime;
/*      */     
/*      */     private String remarkname;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  791 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  796 */       this.valuelimitmap = new HashMap();
/*  797 */       this.valuelimittotalmap = new HashMap();
/*  798 */       this.remarkname = "";
/*      */     }
/*      */     
/*      */     Data(xbean.FriendInfo _o1_)
/*      */     {
/*  803 */       if ((_o1_ instanceof FriendInfo)) { assign((FriendInfo)_o1_);
/*  804 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  805 */       } else if ((_o1_ instanceof FriendInfo.Const)) assign(((FriendInfo.Const)_o1_).nThis()); else {
/*  806 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(FriendInfo _o_) {
/*  811 */       this.relationvalue = _o_.relationvalue;
/*  812 */       this.valuelimitmap = new HashMap();
/*  813 */       for (Map.Entry<Integer, Integer> _e_ : _o_.valuelimitmap.entrySet())
/*  814 */         this.valuelimitmap.put(_e_.getKey(), _e_.getValue());
/*  815 */       this.valuelimittotalmap = new HashMap();
/*  816 */       for (Map.Entry<Integer, Integer> _e_ : _o_.valuelimittotalmap.entrySet())
/*  817 */         this.valuelimittotalmap.put(_e_.getKey(), _e_.getValue());
/*  818 */       this.befriendtime = _o_.befriendtime;
/*  819 */       this.remarkname = _o_.remarkname;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  824 */       this.relationvalue = _o_.relationvalue;
/*  825 */       this.valuelimitmap = new HashMap();
/*  826 */       for (Map.Entry<Integer, Integer> _e_ : _o_.valuelimitmap.entrySet())
/*  827 */         this.valuelimitmap.put(_e_.getKey(), _e_.getValue());
/*  828 */       this.valuelimittotalmap = new HashMap();
/*  829 */       for (Map.Entry<Integer, Integer> _e_ : _o_.valuelimittotalmap.entrySet())
/*  830 */         this.valuelimittotalmap.put(_e_.getKey(), _e_.getValue());
/*  831 */       this.befriendtime = _o_.befriendtime;
/*  832 */       this.remarkname = _o_.remarkname;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  838 */       _os_.marshal(this.relationvalue);
/*  839 */       _os_.compact_uint32(this.valuelimitmap.size());
/*  840 */       for (Map.Entry<Integer, Integer> _e_ : this.valuelimitmap.entrySet())
/*      */       {
/*  842 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  843 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  845 */       _os_.compact_uint32(this.valuelimittotalmap.size());
/*  846 */       for (Map.Entry<Integer, Integer> _e_ : this.valuelimittotalmap.entrySet())
/*      */       {
/*  848 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  849 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  851 */       _os_.marshal(this.befriendtime);
/*  852 */       _os_.marshal(this.remarkname, "UTF-16LE");
/*  853 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  859 */       this.relationvalue = _os_.unmarshal_int();
/*      */       
/*  861 */       int size = _os_.uncompact_uint32();
/*  862 */       if (size >= 12)
/*      */       {
/*  864 */         this.valuelimitmap = new HashMap(size * 2);
/*      */       }
/*  866 */       for (; size > 0; size--)
/*      */       {
/*  868 */         int _k_ = 0;
/*  869 */         _k_ = _os_.unmarshal_int();
/*  870 */         int _v_ = 0;
/*  871 */         _v_ = _os_.unmarshal_int();
/*  872 */         this.valuelimitmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*      */ 
/*  876 */       int size = _os_.uncompact_uint32();
/*  877 */       if (size >= 12)
/*      */       {
/*  879 */         this.valuelimittotalmap = new HashMap(size * 2);
/*      */       }
/*  881 */       for (; size > 0; size--)
/*      */       {
/*  883 */         int _k_ = 0;
/*  884 */         _k_ = _os_.unmarshal_int();
/*  885 */         int _v_ = 0;
/*  886 */         _v_ = _os_.unmarshal_int();
/*  887 */         this.valuelimittotalmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  890 */       this.befriendtime = _os_.unmarshal_long();
/*  891 */       this.remarkname = _os_.unmarshal_String("UTF-16LE");
/*  892 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  898 */       int _size_ = 0;
/*  899 */       _size_ += CodedOutputStream.computeInt32Size(1, this.relationvalue);
/*  900 */       for (Map.Entry<Integer, Integer> _e_ : this.valuelimitmap.entrySet())
/*      */       {
/*  902 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/*  903 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  905 */       for (Map.Entry<Integer, Integer> _e_ : this.valuelimittotalmap.entrySet())
/*      */       {
/*  907 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/*  908 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  910 */       _size_ += CodedOutputStream.computeInt64Size(4, this.befriendtime);
/*      */       try
/*      */       {
/*  913 */         _size_ += CodedOutputStream.computeBytesSize(5, ppbio.ByteString.copyFrom(this.remarkname, "UTF-16LE"));
/*      */       }
/*      */       catch (java.io.UnsupportedEncodingException e)
/*      */       {
/*  917 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*  919 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  927 */         _output_.writeInt32(1, this.relationvalue);
/*  928 */         for (Map.Entry<Integer, Integer> _e_ : this.valuelimitmap.entrySet())
/*      */         {
/*  930 */           _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/*  931 */           _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*  933 */         for (Map.Entry<Integer, Integer> _e_ : this.valuelimittotalmap.entrySet())
/*      */         {
/*  935 */           _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/*  936 */           _output_.writeInt32(3, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*  938 */         _output_.writeInt64(4, this.befriendtime);
/*  939 */         _output_.writeBytes(5, ppbio.ByteString.copyFrom(this.remarkname, "UTF-16LE"));
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  943 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  945 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  953 */         boolean done = false;
/*  954 */         while (!done)
/*      */         {
/*  956 */           int tag = _input_.readTag();
/*  957 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  961 */             done = true;
/*  962 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  966 */             this.relationvalue = _input_.readInt32();
/*  967 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  971 */             int _k_ = 0;
/*  972 */             _k_ = _input_.readInt32();
/*  973 */             int readTag = _input_.readTag();
/*  974 */             if (16 != readTag)
/*      */             {
/*  976 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  978 */             int _v_ = 0;
/*  979 */             _v_ = _input_.readInt32();
/*  980 */             this.valuelimitmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  981 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  985 */             int _k_ = 0;
/*  986 */             _k_ = _input_.readInt32();
/*  987 */             int readTag = _input_.readTag();
/*  988 */             if (24 != readTag)
/*      */             {
/*  990 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  992 */             int _v_ = 0;
/*  993 */             _v_ = _input_.readInt32();
/*  994 */             this.valuelimittotalmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  995 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  999 */             this.befriendtime = _input_.readInt64();
/* 1000 */             break;
/*      */           
/*      */ 
/*      */           case 42: 
/* 1004 */             this.remarkname = _input_.readBytes().toString("UTF-16LE");
/* 1005 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1009 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1011 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1020 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1024 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1026 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FriendInfo copy()
/*      */     {
/* 1032 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FriendInfo toData()
/*      */     {
/* 1038 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.FriendInfo toBean()
/*      */     {
/* 1043 */       return new FriendInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FriendInfo toDataIf()
/*      */     {
/* 1049 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.FriendInfo toBeanIf()
/*      */     {
/* 1054 */       return new FriendInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1060 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1064 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1068 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1072 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1076 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1080 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1084 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRelationvalue()
/*      */     {
/* 1091 */       return this.relationvalue;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getValuelimitmap()
/*      */     {
/* 1098 */       return this.valuelimitmap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getValuelimitmapAsData()
/*      */     {
/* 1105 */       return this.valuelimitmap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getValuelimittotalmap()
/*      */     {
/* 1112 */       return this.valuelimittotalmap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getValuelimittotalmapAsData()
/*      */     {
/* 1119 */       return this.valuelimittotalmap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBefriendtime()
/*      */     {
/* 1126 */       return this.befriendtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getRemarkname()
/*      */     {
/* 1133 */       return this.remarkname;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getRemarknameOctets()
/*      */     {
/* 1140 */       return Octets.wrap(getRemarkname(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRelationvalue(int _v_)
/*      */     {
/* 1147 */       this.relationvalue = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBefriendtime(long _v_)
/*      */     {
/* 1154 */       this.befriendtime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRemarkname(String _v_)
/*      */     {
/* 1161 */       if (null == _v_)
/* 1162 */         throw new NullPointerException();
/* 1163 */       this.remarkname = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRemarknameOctets(Octets _v_)
/*      */     {
/* 1170 */       setRemarkname(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1176 */       if (!(_o1_ instanceof Data)) return false;
/* 1177 */       Data _o_ = (Data)_o1_;
/* 1178 */       if (this.relationvalue != _o_.relationvalue) return false;
/* 1179 */       if (!this.valuelimitmap.equals(_o_.valuelimitmap)) return false;
/* 1180 */       if (!this.valuelimittotalmap.equals(_o_.valuelimittotalmap)) return false;
/* 1181 */       if (this.befriendtime != _o_.befriendtime) return false;
/* 1182 */       if (!this.remarkname.equals(_o_.remarkname)) return false;
/* 1183 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1189 */       int _h_ = 0;
/* 1190 */       _h_ += this.relationvalue;
/* 1191 */       _h_ += this.valuelimitmap.hashCode();
/* 1192 */       _h_ += this.valuelimittotalmap.hashCode();
/* 1193 */       _h_ = (int)(_h_ + this.befriendtime);
/* 1194 */       _h_ += this.remarkname.hashCode();
/* 1195 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1201 */       StringBuilder _sb_ = new StringBuilder();
/* 1202 */       _sb_.append("(");
/* 1203 */       _sb_.append(this.relationvalue);
/* 1204 */       _sb_.append(",");
/* 1205 */       _sb_.append(this.valuelimitmap);
/* 1206 */       _sb_.append(",");
/* 1207 */       _sb_.append(this.valuelimittotalmap);
/* 1208 */       _sb_.append(",");
/* 1209 */       _sb_.append(this.befriendtime);
/* 1210 */       _sb_.append(",");
/* 1211 */       _sb_.append("'").append(this.remarkname).append("'");
/* 1212 */       _sb_.append(")");
/* 1213 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FriendInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */